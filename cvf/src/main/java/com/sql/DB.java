package com.sql;

import java.io.Serializable;

/**
 * 数据库链接
 * @author bobo
 *
 */
public class DB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1710023363113750006L;
	private String id;
	private String user;
	private String dbname;
	private String type;
	private String ip;
	private int port;
	
	private String driver;
	private String url;
	private String username;
	private String password;
	private String commont;
	
	public DB(){}
	
	@Override
	public String toString() {
		return "DB [id=" + id + ", user=" + user + ", dbname=" + dbname
				+ ", type=" + type + ", ip=" + ip + ", port=" + port + ", url="
				+ url + ", username=" + username + ", password=" + password
				+ ", commont=" + commont + "]";
	}
	public DB(String id, String user, String dbname, String type, String url,
			String username, String password) {
		this.id = id;
		this.user = user;
		this.dbname = dbname;
		this.type = type;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCommont() {
		return commont;
	}
	public void setCommont(String commont) {
		this.commont = commont;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}

	
	
}
