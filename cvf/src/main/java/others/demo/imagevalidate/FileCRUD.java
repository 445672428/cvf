package others.demo.imagevalidate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
/**
 * java jvm执行原理
 * java source 编译java.class文件  通过class loader 和engine引擎进行加载  
 * java代码会编译成为字节码  jre来加载器从硬盘上面来读取class文件加载到jvm的内存区域运行数据区 
 * 然后执行引擎或者编译类文件转换成特定的cpu的机器码 通过类加载器来完成
 * 
 * 类加载器
 * bootstrap class loader  在jvm启动就创建 包含最基础的api
 * jvm加载一个类的时候下层的加载器会将任务委托给上层类加载器，上层判断这个类是否加载如果加载了就使用，如果没有就委托下面类加载器直到找个这个类
 * 
 * 运行数据区域
 * 系统为它分配一片区域 这个内存区域由jvm自己来进行创建
 * 主要分为六大区域 java栈、寄存器、本地方法栈、java堆、方法区域、运行常量池。
 * 方法栈当程序通过jni调用本地方法就根据本地方法的语言类型建立相应的栈
 * 
 * 方法区域
 * 方法区域是一个jvm实例中所有线程共享的，当启动一个jvm实例时，方法区域被创建
 * 
 * 运行常量池
 * 这个区域存放类和接口的常量，此外它还存放方法和域的所有引用。
 * 
 * 堆
 * 堆中存放所有创建类的实例
 * 
 * 执行引擎
 * 类加载器将字节码载入内存之后，执性引擎以java字节码的意愿来读取java字节码。
 * 
 * 
 * */
public class FileCRUD {
    // 复制文件
    public boolean copyfile(String oldpath, String newpath) {
        boolean result = false;
        int bytesum = 0;
        int byteread = 0;
        File oldfile = new File(oldpath);
        try {
            if (oldfile.exists()) {
                InputStream inputStream = new FileInputStream(oldfile);
                FileOutputStream outputStream = new FileOutputStream(newpath);
                byte[] buffer = new byte[1024];
                while ((byteread = inputStream.read(buffer)) != -1) {
                    bytesum += byteread;
                    outputStream.write(buffer, 0, byteread);
                }
                inputStream.close();
                result = true;
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    // 复制整个文件夹内容
    public boolean copyfolder(String oldpath, String newpath) {
        boolean result = false;
        new File(newpath).mkdirs();// 如果文件夹不存在就进行文件夹创建
        File file = new File(oldpath);
        String[] files = file.list();
        File tempfile = null;
        try {
            for (int i = 0; i < files.length; i++) {
                if (oldpath.endsWith(File.separator)) {
                    tempfile = new File(oldpath + files[i]);
                } else {
                    tempfile = new File(oldpath + File.separator + files[i]);
                }
                if (tempfile.isFile()) {
                    FileInputStream inputStream = new FileInputStream(tempfile);
                    FileOutputStream outputStream = new FileOutputStream(newpath + "/"
                            + (tempfile.getName()).toString());
                    byte[] b = new byte[1024];
                    int len = 0;
                    while ((len = inputStream.read()) != -1) {
                        outputStream.write(b, 0, len);
                    }
                    outputStream.flush();
                    outputStream.close();
                    inputStream.close();
                }
                if (tempfile.isDirectory()) {
                    copyfolder(oldpath + "/" + files[i], newpath + "/" + files[i]);
                }
            }
            result = true;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            result = false;
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            result = false;
            e.printStackTrace();
        }

        return result;
    }
    
    
    //删除文件夹所有文件
    public boolean deleteAllFile(String path) {
        boolean result = false;
        try {
            File file = new File(path);
            if (!file.exists()) {
                return false;
            }
            if (!file.isDirectory()) {
                return false;
            }
            String[] temps = file.list();
            File tempfile = null;
            for(int i = 0; i < temps.length; i++){
                if (path.endsWith(File.separator)) {
                    tempfile = new File(path+temps[i]);
                }else{
                    tempfile = new File(path + File.separator+temps[i]);
                }
                if(tempfile.isFile()){
                    tempfile.delete();
                }
                if (tempfile.isDirectory()) {
                    deleteAllFile(path+"/"+temps[i]);//先删除文件夹里面的内容
                    deleteFolder(path+"/"+temps[i]);//在删除空的文件夹
                }
            }
            result = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result = false;
            e.printStackTrace();
        }
        return result;
    }
    //移动到指定的文件夹中
    public boolean movetoFolder(String oldpath,String newpath) {
        boolean result = false;
        result = copyfile(oldpath, newpath);
        result = deleteFolder(oldpath);
        return result;
    }
    //删除这个文件夹
    public boolean deleteFolder(String folderPath) {
        boolean result = false;
        try {
            deleteAllFile(folderPath);
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFile = new File(filePath);
            myFile.delete();
            result = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result = false;
            e.printStackTrace();
        }
        return result;
    }
    //新建文件夹
    public boolean addnewFile(String filepathandname,String contentfile) {
        boolean result = false;
        String filepath = filepathandname;
        filepath = filepath.toString();
        try {
            File myFilePath = new File(filepath);
            if (!myFilePath.exists()) {
                myFilePath.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(myFilePath);
            PrintWriter myFile = new PrintWriter(filepath);
            String content = contentfile;
            myFile.println(content);
            fileWriter.close();
            result = true;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            result = false;
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            result = false;
            e.printStackTrace();
        }
        return false;
    }
    
    //新建目录
    public boolean newFolder(String folderPath) {
        boolean result = false;
        try {
            folderPath = folderPath.toString();
            File myFile = new File(folderPath);
            if (!myFile.exists()) {
                myFile.mkdir();
            }
            result = true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            result = false;
            e.printStackTrace();
        }
        return result;
    }
}
