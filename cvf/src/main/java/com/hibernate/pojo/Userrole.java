package com.hibernate.pojo;

/**
 * Userrole entity. @author MyEclipse Persistence Tools
 */

public class Userrole implements java.io.Serializable {

	// Fields

	private UserroleId id;
	private String vchar1;

	// Constructors

	/** default constructor */
	public Userrole() {
	}

	/** minimal constructor */
	public Userrole(UserroleId id) {
		this.id = id;
	}

	/** full constructor */
	public Userrole(UserroleId id, String vchar1) {
		this.id = id;
		this.vchar1 = vchar1;
	}

	// Property accessors

	public UserroleId getId() {
		return this.id;
	}

	public void setId(UserroleId id) {
		this.id = id;
	}

	public String getVchar1() {
		return this.vchar1;
	}

	public void setVchar1(String vchar1) {
		this.vchar1 = vchar1;
	}

}