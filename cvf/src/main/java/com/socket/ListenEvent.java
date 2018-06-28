package com.socket;

import java.util.concurrent.ConcurrentLinkedQueue;

public final class ListenEvent {
	public static volatile ConcurrentLinkedQueue<String> msgQueue = new ConcurrentLinkedQueue<String>();
	
	private static final ListenEvent listenEvent = new ListenEvent();
	
	public static ListenEvent getInstance(){
		return listenEvent;
	}
	
	public static synchronized ConcurrentLinkedQueue<String> add(String msg){
		msgQueue.add(msg);
		return msgQueue;
	}
	
	public static synchronized ConcurrentLinkedQueue<String> remove(String msg){
		msgQueue.remove(msg);
		return msgQueue;
	}
	
}
