package com.hibernate.pojo;

/**
 * Servers entity. @author MyEclipse Persistence Tools
 */

public class Servers implements java.io.Serializable {

	// Fields

	private String serverName;
	private String host;
	private String db;
	private String username;
	private String password;
	private Integer port;
	private String socket;
	private String wrapper;
	private String owner;

	// Constructors

	/** default constructor */
	public Servers() {
	}

	/** full constructor */
	public Servers(String serverName, String host, String db, String username,
			String password, Integer port, String socket, String wrapper,
			String owner) {
		this.serverName = serverName;
		this.host = host;
		this.db = db;
		this.username = username;
		this.password = password;
		this.port = port;
		this.socket = socket;
		this.wrapper = wrapper;
		this.owner = owner;
	}

	// Property accessors

	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDb() {
		return this.db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPort() {
		return this.port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getSocket() {
		return this.socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getWrapper() {
		return this.wrapper;
	}

	public void setWrapper(String wrapper) {
		this.wrapper = wrapper;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}