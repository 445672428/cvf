package com.entities;

import java.io.Serializable;

/**
 * 用户信息
 * @author bobo
 *
 */
public class TUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userName;
	private String passWord;
	private String email;
	private String mobile;
	private Long id;
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPassWord() {
		return passWord;
	}
	public TUser(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public TUser(){}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
