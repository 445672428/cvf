package com.push;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

public class MyHandShake implements HandshakeInterceptor {

	@Override
	public boolean beforeHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		try {
			if (request instanceof ServletServerHttpRequest) {
				ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
				String uid = servletRequest.getServletRequest().getParameter("uid");
				if (uid != null) {
					attributes.put("uid", uid);
				} else {
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return false;
		}
	}

	@Override
	public void afterHandshake(ServerHttpRequest request,
			ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {

	}

}
