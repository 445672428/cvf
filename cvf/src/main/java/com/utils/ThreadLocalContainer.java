package com.utils;

import org.apache.http.HttpRequest;

import com.entities.TUser;

public class ThreadLocalContainer {
	private static final ThreadLocal<Object> contexts = new ThreadLocal<Object>();
    // 拿出当前线程绑定的 context
    public static ThreadLocalContainer getCurrentContext() {
        return (ThreadLocalContainer) contexts.get();
    }
    public static ThreadLocalContainer createContext() {
        return new ThreadLocalContainer();
    }
    // 绑定一个 context 到当前线程 
    public static void setContext(ThreadLocalContainer context) {
        contexts.set(context);
    }
    public static void clearContext() {
        contexts.set(null);
    }
    private TUser tUser;
    public void settUser(TUser tUser) {
		this.tUser = tUser;
	}
    public TUser gettUser() {
		return tUser;
	}
    private HttpRequest request;
    public void setRequest(HttpRequest request) {
        this.request = request;
    }
    public HttpRequest getRequest() {
        return this.request;
    }
}
