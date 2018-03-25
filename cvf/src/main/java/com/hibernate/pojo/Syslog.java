package com.hibernate.pojo;

import java.sql.Timestamp;

/**
 * Syslog entity. @author MyEclipse Persistence Tools
 */

public class Syslog implements java.io.Serializable {

	// Fields

	private String id;
	private String userid;
	private Timestamp operatedate;
	private String userip;
	private String username;
	private String logtype;
	private String messages;

	// Constructors

	/** default constructor */
	public Syslog() {
	}

	/** minimal constructor */
	public Syslog(String id) {
		this.id = id;
	}

	/** full constructor */
	public Syslog(String id, String userid, Timestamp operatedate,
			String userip, String username, String logtype, String messages) {
		this.id = id;
		this.userid = userid;
		this.operatedate = operatedate;
		this.userip = userip;
		this.username = username;
		this.logtype = logtype;
		this.messages = messages;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Timestamp getOperatedate() {
		return this.operatedate;
	}

	public void setOperatedate(Timestamp operatedate) {
		this.operatedate = operatedate;
	}

	public String getUserip() {
		return this.userip;
	}

	public void setUserip(String userip) {
		this.userip = userip;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLogtype() {
		return this.logtype;
	}

	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}

	public String getMessages() {
		return this.messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

}