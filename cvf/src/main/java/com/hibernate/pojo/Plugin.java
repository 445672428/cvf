package com.hibernate.pojo;

/**
 * Plugin entity. @author MyEclipse Persistence Tools
 */

public class Plugin implements java.io.Serializable {

	// Fields

	private String name;
	private String dl;

	// Constructors

	/** default constructor */
	public Plugin() {
	}

	/** full constructor */
	public Plugin(String name, String dl) {
		this.name = name;
		this.dl = dl;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDl() {
		return this.dl;
	}

	public void setDl(String dl) {
		this.dl = dl;
	}

}