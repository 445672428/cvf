package com.theadRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

import com.data.MysqlDBUtils;

public class InterfaceRuner {
	String sql = "INSERT INTO images (id,name,url,code,tag,appname,flag,createtime,updatetime) VALUES(?,?,?,?,?,?,?,?,?)";
	public static void main(String[] args) {
		String _PATH = "D:\\temp\\美图";
		File file = new File(_PATH);
		BlockingQueue<File> files = new LinkedBlockingDeque<File>();
		String newPath = "D:\\temp\\image2";
		File newFile = new File(newPath);
		if (newFile.exists()) {
			System.out.println("文件夹存在");
		}else{
			newFile.mkdir();
		}
		InterfaceRuner interfaceRuner = new InterfaceRuner();
		ExecutorService service = Executors.newFixedThreadPool(4);
		for(File f : file.listFiles()){
			if (f.isDirectory()) {
				service.execute(interfaceRuner.new DealFile(files, f));
			}else{
				files.add(f);  
			}
		}
		service.shutdown();
		System.out.println("文件个数====="+files.size());
	}
	
	private class DealFile implements Runnable{
		BlockingQueue<File> files = null;
		File file = null;
		private Connection connection;
		public DealFile(BlockingQueue<File> files,File file){
			this.files = files;
			this.file = file;
			this.connection = MysqlDBUtils.getConnection();
		}
		@Override
		public void run() {
			getFileName(file.listFiles());
		}
		private final void getFileName(File[] fileDirectory){
			for(File f : fileDirectory){
				if (f.isDirectory()) {
					getFileName(f.listFiles());
				}else{
					System.out.println("文件路径"+f.getAbsolutePath());
					files.add(f);
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
						PreparedStatement statement = null;
						statement = connection.prepareStatement(sql);
						String name = f.getParent();
						String url = f.getAbsolutePath();
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

}
