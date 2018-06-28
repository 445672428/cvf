package com.push;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebsocketHandler extends TextWebSocketHandler {
	private final static Logger LOG = Logger.getLogger(WebsocketHandler.class);
	public static ConcurrentHashMap<String, WebSocketSession> websocketSessionsConcurrentHashMap;
	public static ConcurrentHashMap<String, WebSocketSession> websocketSessionsConcurrentHashMapForLog;

	static {
		websocketSessionsConcurrentHashMap = new ConcurrentHashMap<String, WebSocketSession>();
		websocketSessionsConcurrentHashMapForLog = new ConcurrentHashMap<String, WebSocketSession>();
	}

	public void afterConnectionEstablished(WebSocketSession session) {
		try {
			String uid = (String) session.getAttributes().get("uid");
			if (!(uid == null)) {
				if (uid.equals("log")) {
					if (websocketSessionsConcurrentHashMapForLog.get(uid) == null) {
						websocketSessionsConcurrentHashMapForLog.put(
								uid + Math.random(), session);
					} else {
						websocketSessionsConcurrentHashMapForLog.get(uid)
								.close();
						websocketSessionsConcurrentHashMapForLog.put(
								uid + Math.random(), session);
					}
				} else {
					if (websocketSessionsConcurrentHashMap.get(uid) == null) {
						websocketSessionsConcurrentHashMap.put(uid, session);
					} else {
						websocketSessionsConcurrentHashMap.get(uid).close();
						websocketSessionsConcurrentHashMap.put(uid, session);
					}
				}
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOG.warn(sw.toString());
			e.printStackTrace();
		}

	}

	public void handleMessage(WebSocketSession session,
			WebSocketMessage<?> message) {
		try {
			if (message.getPayloadLength() == 0)
				return;
			String id = UUID.randomUUID().toString();
			sendMessageToUser(id, new TextMessage(id));
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOG.warn(sw.toString());
			e.printStackTrace();
		}

	}

	
	public void handleTransportError(WebSocketSession session,Throwable exception) {
		try {
			if (session.isOpen()) {
				session.close();
			}
			Iterator<Entry<String, WebSocketSession>> it = websocketSessionsConcurrentHashMap.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, WebSocketSession> entry = it.next();
				if (entry.getValue().getId().equals(session.getId())) {
					websocketSessionsConcurrentHashMap.remove(entry.getKey());
					break;
				}
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOG.warn(sw.toString());
			e.printStackTrace();
		}

	}

	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus closeStatus) {
		try {
			Iterator<Entry<String, WebSocketSession>> it = websocketSessionsConcurrentHashMap
					.entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, WebSocketSession> entry = it.next();
				if (entry.getValue().getId().equals(session.getId())) {
					websocketSessionsConcurrentHashMap.remove(entry.getKey());
					break;
				}
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOG.warn(sw.toString());
			e.printStackTrace();
		}

	}

	public boolean supportsPartialMessages() {
		return false;
	}

	public static void broadcast(final TextMessage message) {
		try {
			Iterator<Entry<String, WebSocketSession>> it = websocketSessionsConcurrentHashMap
					.entrySet().iterator();

			while (it.hasNext()) {

				final Entry<String, WebSocketSession> entry = it.next();

				if (entry.getValue().isOpen()) {
					new Thread(new Runnable() {

						public void run() {
							try {
								if (entry.getValue().isOpen()) {
									entry.getValue().sendMessage(message);
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
						}

					}).start();
				}
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOG.warn(sw.toString());
			e.printStackTrace();
		}

	}

	public static void sendMessageToUser(Object uid, TextMessage message) {
		try {
			WebSocketSession session = websocketSessionsConcurrentHashMap
					.get(uid);
			if (session != null && session.isOpen()) {
				session.sendMessage(message);
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOG.warn(sw.toString());
			e.printStackTrace();
		}
	}

	public static void sendMessageToUser(Object uid, String message) {
		try {
			WebSocketSession session = websocketSessionsConcurrentHashMap
					.get(uid);
			if (session != null && session.isOpen()) {
				session.sendMessage(new TextMessage(message));
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOG.warn("send message to user�����쳣");
			LOG.warn(sw.toString());
			e.printStackTrace();
		}
	}

	public static void broadcastLog(final String log) {
		try {
			Iterator<Entry<String, WebSocketSession>> it = websocketSessionsConcurrentHashMapForLog
					.entrySet().iterator();
			while (it.hasNext()) {
				final Entry<String, WebSocketSession> entry = it.next();
				Object uid = entry.getKey();
				WebSocketSession session = websocketSessionsConcurrentHashMapForLog
						.get(uid);
				if (session != null && session.isOpen()) {
					session.sendMessage(new TextMessage(log));
				}
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOG.warn(sw.toString());
			e.printStackTrace();
		}

	}

	public static void broadcast(
			ConcurrentHashMap<String, WebSocketSession> hashMap,
			final String message) {
		try {
			Iterator<Entry<String, WebSocketSession>> it = hashMap.entrySet()
					.iterator();
			while (it.hasNext()) {
				final Entry<String, WebSocketSession> entry = it.next();
				if (entry.getValue().isOpen()) {
					new Thread(new Runnable() {
						public void run() {
							if (entry.getValue().isOpen()) {
								sendMessageToUser(entry.getValue(), message);
							}
						}
					}).start();
				}
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			LOG.warn(sw.toString());
			e.printStackTrace();
		}
	}
}
