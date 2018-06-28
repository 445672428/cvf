package com.socket;

import java.io.File;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFileManager {
	protected static Logger logger = LoggerFactory.getLogger(LogFileManager.class);
	// 用来记录当前在线连接数
	private static volatile int onlineCount = 0;

	// 标记文件已读行数
	private static volatile long lines = 0L;//这里需要判断上面读的文件是多少行  如果下行是空就返回当前的行  如果跨行 暂时不处理  对于 对应的文件进行处理 

	// 判断是否是第一次加载
	private static volatile boolean isFirstRunning = true;
	
	public static CopyOnWriteArraySet<LogConfigSocket> webSocketSet = new CopyOnWriteArraySet<LogConfigSocket>();
	
	// 开启监听
	public static synchronized void startListening(String rootDir) {
		if (!isFirstRunning) {
			logger.error("监听服务已经启动!");
			return;
		}
		// 监控目录
		// 轮询间隔 1 秒
		long interval = TimeUnit.SECONDS.toMillis(2);
		
		File directory = new File(rootDir); 
		// 创建一个文件观察器用于处理文件的格式
		
		 
        FileAlterationObserver observer = new FileAlterationObserver(directory, 
        		FileFilterUtils.and(FileFilterUtils.fileFileFilter(),FileFilterUtils.suffixFileFilter(".txt")));  
		
        observer.addListener(new LogFileListenerAdaptor(webSocketSet));
		// 创建文件变化监听器
		FileAlterationMonitor monitor = new FileAlterationMonitor(interval,observer);
		// 开始监控
		try {
			monitor.start();
			isFirstRunning = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		onlineCount--;
	}
	
}
