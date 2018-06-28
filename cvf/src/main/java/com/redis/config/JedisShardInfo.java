package com.redis.config;
/**
 * jedis配置信息
 * @author bobo
 *
 */
public class JedisShardInfo {
	private String ip;
	private int port;
	private String node;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public JedisShardInfo(){}
	public JedisShardInfo(String ip, int port, String node) {
		super();
		this.ip = ip;
		this.port = port;
		this.node = node;
	}
}
