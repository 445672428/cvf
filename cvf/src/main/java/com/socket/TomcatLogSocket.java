package com.socket;

import java.io.File;
import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/tomcat/websocket/log",configurator=SocketConfigurator.class)
public class TomcatLogSocket implements LogConfigSocket{
	
    private Session session;
	
    public TomcatLogSocket() {
    	String path = System.getProperty("catalina.home");//
    	System.getProperty("user.dir");//
        String classesPath = this.getClass().getResource("/").getPath();
        String logRootPath = new File(classesPath).getParentFile().getParentFile().getParentFile().getParentFile().getPath() + File.separator + "logs";
        LogFileManager.startListening(logRootPath);
        
    }

    public Session getSession() {
        return session;
    }
	
	@OnOpen
	public void onOpen(Session session){
		this.session = session;
		LogFileManager.webSocketSet.add(this);
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose(){
		LogFileManager.webSocketSet.remove(this);  // 从set中删除
		LogFileManager.subOnlineCount();           // 在线数减1
	}

	/**
	 * 收到客户端消息后调用的方法
	 * @param message 客户端发送过来的消息
	 * @param session 可选的参数
	 */
	@OnMessage
	public void onMessage(String message, Session session) {
	}

	/**
	 * 发生错误时调用
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error){
		error.printStackTrace();
	}

}
