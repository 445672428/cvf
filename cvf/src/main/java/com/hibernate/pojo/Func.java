package com.hibernate.pojo;

/**
 * Func entity. @author MyEclipse Persistence Tools
 */

public class Func implements java.io.Serializable {

	// Fields

	private String name;
	private Boolean ret;
	private String dl;
	private String type;

	// Constructors

	/** default constructor */
	public Func() {
	}

	/** full constructor */
	public Func(String name, Boolean ret, String dl, String type) {
		this.name = name;
		this.ret = ret;
		this.dl = dl;
		this.type = type;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRet() {
		return this.ret;
	}

	public void setRet(Boolean ret) {
		this.ret = ret;
	}

	public String getDl() {
		return this.dl;
	}

	public void setDl(String dl) {
		this.dl = dl;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}