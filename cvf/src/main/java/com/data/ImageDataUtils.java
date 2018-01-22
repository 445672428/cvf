package com.data;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.imageio.ImageIO;

import com.theadRun.ImageDownThead;

public class ImageDataUtils {
	static public volatile int index = 0;
	public static void main(String[] args) throws SQLException {
		ImageDataUtils imageDataUtils = new ImageDataUtils();
		imageDataUtils.insertImageInfo();
		//imageTxtSql();
	}
    //--------------------------------------------------------------------------------------------------------------------------------------------------//
    
	public void insertImage(){
    	final String _URL1 = "D:\\picTest1"; 
    	final String _URL2 = "D:\\picTest2"; 
    	final String _URL3 = "D:\\picTest3"; 
    	final String _URL4 = "D:\\picTest4";
    	final String _PATH = "D:\\images";
    	File file = new File(_PATH);
    	if (file.exists()) {
    		//file.delete();
			System.out.println("有同名的文件夹");
		}else{
			file.mkdirs();
		}
    	ImageDownThead downThead1 = new ImageDownThead(_URL1, file);
    	ImageDownThead downThead2 = new ImageDownThead(_URL2, file);
    	ImageDownThead downThead3 = new ImageDownThead(_URL3, file);
    	ImageDownThead downThead4 = new ImageDownThead(_URL4, file);
    	downThead1.setName("thread1");
    	downThead1.start();
    	downThead2.setName("thread2");
    	downThead2.start();
    	downThead3.setName("thread3");
    	downThead3.start();
    	downThead4.setName("thread4");
    	downThead4.start();
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------------//
   
	
	public static void imageTxtSql() {
    	final String filePath = "D:\\temp\\美图\\";
    	final List<String> fileNames = new ArrayList<String>();
    	ExecutorService service = Executors.newFixedThreadPool(6);
    	final long a3 = System.currentTimeMillis();
    	File wFile = new File("C:\\txttemp1\\1.sql");
    	if(wFile.delete()){
    		wFile.delete();
    	}
    	
    	File oFile = new File("D:\\search1\\");
    	if (!oFile.exists()) {
    		oFile.mkdir();
		}else{
			for(File f:oFile.listFiles()){
				f.delete();
			}
		}
    	service.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("进来了!");
		    	getChildsFile(filePath,fileNames);
		    	long a4 = System.currentTimeMillis();
		    	System.out.println(a4-a3);
			}
		});
    	service.shutdown();  
	}
	final private static String search = "D:\\search1";
    public static void getChildsFile(String path,List<String> fileNames){
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                    	getChildsFile(file2.getAbsolutePath(),fileNames);
                    } else {
                    	fileNames.add(file2.getAbsolutePath());//保持文件路径
                    	
						InputStream inputStream = null;
						OutputStream outputStream = null;
                        FileWriter fileWriter = null;
                        BufferedWriter writer = null;
                        String url = file2.getAbsolutePath();
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String time = dateFormat.format(new Date());
						Timestamp timestamp = Timestamp.valueOf(time);
                        try {
    						byte[] b = new byte[1024];
    						int flag = 0;
    						inputStream = new FileInputStream(file2);
    						String uuid = UUID.randomUUID().toString().replaceAll("\\-", "");
    						outputStream = new FileOutputStream(search+"\\"+uuid+file2.getName()+"");//输出的新路径
    						//outputStream = new FileOutputStream(search+"\\"+index+".jpg");//输出的新路径
    						while((flag=inputStream.read(b))!=-1){
    							outputStream.write(b,0,flag);
    							outputStream.flush();
    						}
    						outputStream.flush();
    						String sql = "INSERT INTO images (id,name,url,code,tag,appname,flag,createtime,updatetime,oldurl) "
    		                        + "VALUES('"+uuid+"','"+file2.getName()+"','search\\"+uuid+index+"',1,2,'web',1,'"+timestamp+"','"+timestamp+"','"+url+"');";
							fileWriter = new FileWriter(new File("C:\\txttemp1\\1.sql"),true);
	                    	writer = new BufferedWriter(fileWriter);
	                    	writer.write(sql);
	                    	writer.write("\n");
	                    	writer.flush();
						} catch (IOException e) {
							e.printStackTrace();
						}finally{
							if (writer!=null) {
								try {
									writer.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							if (fileWriter!=null) {
								try {
									fileWriter.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
                        index++;
                    }
                }
            }
        } 
    }
	
	 //--------------------------------------------------------------------------------------------------------------------------------------------------//
	public static void loadImagesUrl() throws SQLException{
    	String sql = "INSERT INTO images (id,name,url,code,tag,appname,flag,createtime,updatetime) VALUES(?,?,?,?,?,?,?,?,?)";
    	String pathname = "D:\\temp\\美图";
		String newPath = "D:\\temp\\image2";
		File newFile = new File(newPath);
		if (!newFile.exists()) {
    		newFile.mkdir();
		}
    	Connection connection = MysqlDBUtils.getConnection();
    	PreparedStatement statement = null;
    	ResultSet resultSet = null;
    	int fileCount = 0,folderCount = 0;
    	File file = new File(pathname);
    	if (file.exists()) {
			LinkedList<File> list = new LinkedList<File>();
			File[] files = file.listFiles();
			int count = 0;
			for(File f : files){
				if (f.isDirectory()) {
					list.add(f);
					//System.out.println("文件夹:" + f.getAbsolutePath());
					folderCount ++;
				}else{
						InputStream inputStream = null;
						OutputStream outputStream = null;
						byte[] b = new byte[1024];
						int flag = 0;
						try {
						inputStream = new FileInputStream(f);
						//旧路径 +f.getAbsolutePath().replace(f.getParent()+"\\", "")
						outputStream = new FileOutputStream("D:\\temp\\image2"+"\\"+UUID.randomUUID().toString()+".jpg");//输出的新路径
						while((flag=inputStream.read(b))!=-1){
							outputStream.write(b,0,flag);
						}
						//System.out.println("文件:" + f.getAbsolutePath());
						String url = f.getAbsolutePath();
						statement = connection.prepareStatement(sql);
						String name = f.getParent();
						name = url.replace(name+"\\", "");
						statement.setString(1, UUID.randomUUID().toString().replaceAll("\\-", ""));
						statement.setString(2, url);
						statement.setString(3, name);
						statement.setInt(4, 1);
						statement.setInt(5, 2);
						statement.setString(6, "美女");
						statement.setInt(7, 0);
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String time = dateFormat.format(new Date());
						Timestamp timestamp = Timestamp.valueOf(time);
						statement.setTimestamp(8, timestamp);
						statement.setTimestamp(9, timestamp);
						count++;
						System.out.println("sql========="+sql);
						statement.execute();
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						if (outputStream!=null) {
							try {
								outputStream.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if (inputStream!=null) {
							try {
								inputStream.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					fileCount ++;
				}
			}
	    	File temp_file;
	    	while(!list.isEmpty()){
	    		temp_file = list.removeFirst();
	    		files = temp_file.listFiles();
	    		for(File f2 : files){
	    			 if (f2.isDirectory()) {
	                        System.out.println("文件夹:" + f2.getAbsolutePath());
	                        String parent = f2.getParent();
	                        //String parentFile = f2.getParentFile();
	                        list.add(f2);
	                        folderCount++;
	                    } else {
							InputStream inputStream = null;
							OutputStream outputStream = null;
							byte[] b = new byte[1024];
							int flag = 0;
							try {
							inputStream = new FileInputStream(f2);
							//旧路径 +f.getAbsolutePath().replace(f.getParent()+"\\", "")
							outputStream = new FileOutputStream("D:\\temp\\image2"+"\\"+UUID.randomUUID().toString()+".jpg");//输出的新路径
							while((flag=inputStream.read(b))!=-1){
								outputStream.write(b,0,flag);
							}
							//System.out.println("文件:" + f.getAbsolutePath());
							String url = f2.getAbsolutePath();
							statement = connection.prepareStatement(sql);
							String name = f2.getParent();
							name = url.replace(name+"\\", "");
							statement.setString(1, UUID.randomUUID().toString().replaceAll("\\-", ""));
							statement.setString(2, url);
							statement.setString(3, name);
							statement.setInt(4, 1);
							statement.setInt(5, 2);
							statement.setString(6, "美女");
							statement.setInt(7, 0);
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String time = dateFormat.format(new Date());
							Timestamp timestamp = Timestamp.valueOf(time);
							statement.setTimestamp(8, timestamp);
							statement.setTimestamp(9, timestamp);
							count++;
							System.out.println("sql========="+sql);
							statement.execute();
						} catch (Exception e) {
							e.printStackTrace();
						}finally{
							if (outputStream!=null) {
								try {
									outputStream.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							if (inputStream!=null) {
								try {
									inputStream.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
	                }
	    		}
	    	}
		}
    	MysqlDBUtils.closeConnection(connection, statement, resultSet);
    	System.out.println("文件夹====="+folderCount+"文件数====="+fileCount);
    }
    /*--------------------------------------------------------------------------------------------------------------------------------------------
     * 
     * 
     * 递归获取某文件目录下面所有文件
     * 
     * 
     * 
     * --------------------------------------------------------------------------------------------------------------------------------------------
     * */
    
    public void test(){
    	String path = "D:\\美图";
    	traverseFolder2(path);
    }
    public void traverseFolder2(String path) {
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder2(file2.getAbsolutePath());
                    } else {
                    	System.out.println("父文件夹路径:"+file2.getParent());
                        System.out.println("文件:" + file2.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
    
    public void insertImageInfo() {
    	Connection connection = MysqlDBUtils.getConnection();
    	PreparedStatement statement = null;
    	ResultSet resultSet = null;
		String path = "D:\\bobo\\nginx-1.6.3\\search\\cvf\\search\\";
		List<File> list = getFileList(path);
		System.out.println(list.size());
		String abString = "search/";
		int index = 1;
		String outPath = "D://search//";
    	String sql = "INSERT INTO images (id,name,url,code,tag,appname,flag,createtime,updatetime,oldurl,width,height,uindex) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(File file : list){
			String name = file.getName();
			int width = 0;
			int height = 0;
			try {
				BufferedImage image = ImageIO.read(file);
				if (image==null) {
					continue;
				}
				width = image.getWidth();
				height = image.getHeight();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			String url = abString+id+".jpg";//文件路径
			int code = 1;
			int tag = 8;
			String appname = "webapp";
			int flag = 0;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = dateFormat.format(new Date());
			Timestamp createtime = Timestamp.valueOf(time);
			Timestamp updatetime = createtime;
			int uindex = index;
			index ++;
			writeToNewFile(file,outPath+id+".jpg");
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1,id);
				statement.setString(2, name);
				statement.setString(3, url);
				statement.setInt(4, code);
				statement.setInt(5, tag);
				statement.setString(6, appname);
				statement.setInt(7, flag);
				statement.setTimestamp(8, createtime);
				statement.setTimestamp(9, updatetime);
				statement.setString(10, "");
				statement.setInt(11, width);
				statement.setInt(12, height);
				statement.setInt(13, uindex);
				int is = statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		MysqlDBUtils.closeConnection(connection, statement, resultSet);
	}
    
    public void writeToNewFile(File file,String path) {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		byte[] b = new byte[1024];
		int flag = 0;
		try {
			inputStream = new FileInputStream(file);
			outputStream = new FileOutputStream(path);//输出的新路径
			while((flag=inputStream.read(b))!=-1){
				outputStream.write(b,0,flag);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (outputStream!=null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
    
    /*--------------------------------------------------------------------------------------------------------------------------------------------
     * 
     * 
     * 获取某文件目录下面所有文件
     * 
     * 
     * 
     * --------------------------------------------------------------------------------------------------------------------------------------------
     * */
    public List<File> getFileList(String strPath) {
    	List<File> filelist = new ArrayList<File>();
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
                } else if (fileName.endsWith("avi")) { // 判断文件名是否以.avi结尾
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    filelist.add(files[i]);
                } else {
                	 String strFileName = files[i].getAbsolutePath();
                     filelist.add(files[i]);
                }
            }

        }
        return filelist;
    }
    
    
    /*--------------------------------------------------------------------------------------------------------------------------------------------
     * 
     * 
     * 获取盘符所有文件
     * 
     * 
     * 
     * --------------------------------------------------------------------------------------------------------------------------------------------
     * */
    public void getFolderSrc(){
    	long startTime = System.currentTimeMillis();
    	String fileName = "D:"+File.separator;
    	File file = new File(fileName);
    	List<String> paths = print(file);
    	write(paths);
    	long endTime = System.currentTimeMillis();
    	System.out.println("统计时间===="+(endTime-startTime));
    }
    private void write(List<String> list){
    	File file = new File("D:\\美图\\Doc.txt");
    	if (file.exists()) {
			file.delete();
		}else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    	FileWriter writer = null;
    	try {
			writer = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	try {
        	for(String path : list){
        		if (writer!=null) {
    				writer.write(path);
    				writer.write("\r\n");
    			}
        	}
		} catch (IOException e) {
		}finally{
			if (writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

    }
    private List<String> print(File f){
    	List<String> namesList = new ArrayList<String>();
    	if (f!=null) {
			if (f.isDirectory()) {
				File[] files = f.listFiles();
				if (files!=null) {
					for (int i = 0; i < files.length; i++) {
						print(files[i]);
					}
				}
			}else{
				//当前文件不是文件夹
				String fileName = f.getAbsolutePath();
				namesList.add(fileName);
			}
		}
    	return namesList;
    }
}
