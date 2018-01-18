package com.theadRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class ImageDownThead extends Thread{
	private String path;
	private File file;
	public ImageDownThead(String path,File file){
		this.path = path;
		this.file = file;
	}
	@Override
	public void run() {
		
	}
	private void loadImage(){
		long start = System.currentTimeMillis();
		String name = Thread.currentThread().getName();
		System.out.println("name===="+name+"startTime-------"+start);
		File sources = new File(this.path);
		if (sources.isDirectory()) {
			System.out.println("++++++++++++++++++++++++");
			File[] srcs = sources.listFiles();
			for(File img:srcs){
				System.out.println("图片的路径--------"+img.getAbsolutePath());
				byte[] b = new byte[1024];
				int flag = 0;
				InputStream inputStream = null;
				OutputStream outputStream = null;
				try {
					inputStream = new FileInputStream(img);//旧路径
					System.out.println("getAbsolutePath======="+img.getAbsolutePath());
					System.out.println("getParent======="+img.getParent());
					outputStream = new FileOutputStream(file.getAbsoluteFile()+"\\"+UUID.randomUUID().toString()+img.getAbsolutePath().replace(img.getParent()+"\\", ""));//输出的新路径
					System.out.println("-----------------------"+file.getAbsoluteFile()+"\\"+UUID.randomUUID().toString()+img.getAbsolutePath().replace(img.getParent()+"\\", ""));
					while((flag=inputStream.read(b))!=-1){
						outputStream.write(b,0,flag);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					if (outputStream!=null) {
						try {
							outputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (inputStream!=null) {
						try {
							inputStream.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
			}
		}else{
			File[] srcs = sources.listFiles();
			for(File img:srcs){
				System.out.println("图片的路径--------"+img.getAbsolutePath());
			}
		}
	}
}
