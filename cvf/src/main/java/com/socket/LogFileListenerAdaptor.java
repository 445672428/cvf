package com.socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import com.entities.DirectoryInfo;
/**
 * 文件监听器类
 * @author bobo
 *
 */
public class LogFileListenerAdaptor extends FileAlterationListenerAdaptor{
	private CopyOnWriteArraySet<LogConfigSocket> webSocketSet;
	
	public LogFileListenerAdaptor(CopyOnWriteArraySet<LogConfigSocket> webSocketSet){
		this.webSocketSet = webSocketSet;
	}

	@Override
	public void onStart(FileAlterationObserver observer) {
		super.onStart(observer);
	}

	@Override
	public void onDirectoryCreate(File directory) {
		super.onDirectoryCreate(directory);
		DirectoryInfo directoryInfo = new DirectoryInfo(directory,"文件夹被创建");
		sendMsgToAll(directoryInfo.toString());
	}

	@Override
	public void onDirectoryChange(File directory) {
		super.onDirectoryChange(directory);
		DirectoryInfo directoryInfo = new DirectoryInfo(directory,"文件夹被改变");
		sendMsgToAll(directoryInfo.toString());
	}

	@Override
	public void onDirectoryDelete(File directory) {
		DirectoryInfo directoryInfo = new DirectoryInfo(directory,"文件夹被删除");
		sendMsgToAll(directoryInfo.toString());
	}

	@Override
	public void onFileCreate(File file) {
		super.onFileCreate(file);
		DirectoryInfo directoryInfo = new DirectoryInfo(file,"文件被创建");
		sendMsgToAll(directoryInfo.toString());
	}

	@Override
	public void onFileChange(File file) {
		super.onFileChange(file);
		
		BufferedReader br = null;
		InputStreamReader isr = null;
		try {
			isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			br = new BufferedReader(isr);
			String content = "";
			if (br.ready()) {
				while (br.read() != -1) {
					content += br.readLine()+"</br>";
				}
				sendMsgToAll(content);
			}
			isr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFileDelete(File file) {
		super.onFileDelete(file);
		DirectoryInfo directoryInfo = new DirectoryInfo(file,"文件被删除");
		sendMsgToAll(directoryInfo.toString());
	}

	@Override
	public void onStop(FileAlterationObserver observer) {
		super.onStop(observer);
	}

	private void sendMsgToAll(String msg) {
		Iterator<LogConfigSocket> it = webSocketSet.iterator();
		while (it.hasNext()) {
			LogConfigSocket item = it.next();
			try {
				//item.getSession().getBasicRemote().sendText(msg);
				
				while (!ListenEvent.msgQueue.isEmpty()) {
					String t = ListenEvent.msgQueue.poll();
					item.getSession().getBasicRemote().sendText(t);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
public static void main(String[] args) {
	ListenEvent.msgQueue.add("aaa");
	System.out.println(ListenEvent.msgQueue.isEmpty());
	System.out.println(ListenEvent.msgQueue);
	String a = ListenEvent.msgQueue.poll();
	System.out.println(a);
	a = ListenEvent.msgQueue.poll();
	System.out.println(ListenEvent.msgQueue);
	
}
}
