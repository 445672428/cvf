package com.hibernate.pojo;

/**
 * Usergysarea entity. @author MyEclipse Persistence Tools
 */

public class Usergysarea implements java.io.Serializable {

	// Fields

	private UsergysareaId id;
	private String vchar1;
	private String vchar2;
	private String vchar3;

	// Constructors

	/** default constructor */
	public Usergysarea() {
	}

	/** minimal constructor */
	public Usergysarea(UsergysareaId id) {
		this.id = id;
	}

	/** full constructor */
	public Usergysarea(UsergysareaId id, String vchar1, String vchar2,
			String vchar3) {
		this.id = id;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
	}

	// Property accessors

	public UsergysareaId getId() {
		return this.id;
	}

	public void setId(UsergysareaId id) {
		this.id = id;
	}

	public String getVchar1() {
		return this.vchar1;
	}

	public void setVchar1(String vchar1) {
		this.vchar1 = vchar1;
	}

	public String getVchar2() {
		return this.vchar2;
	}

	public void setVchar2(String vchar2) {
		this.vchar2 = vchar2;
	}

	public String getVchar3() {
		return this.vchar3;
	}

	public void setVchar3(String vchar3) {
		this.vchar3 = vchar3;
	}

}