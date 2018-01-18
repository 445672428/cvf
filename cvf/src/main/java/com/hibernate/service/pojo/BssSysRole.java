package com.hibernate.service.pojo;

/**
 * BssSysRole entity. @author MyEclipse Persistence Tools
 */

public class BssSysRole implements java.io.Serializable {

	// Fields

	private String roleid;
	private String rolename;
	private String roledes;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;
	private String vchar6;

	// Constructors

	/** default constructor */
	public BssSysRole() {
	}

	/** minimal constructor */
	public BssSysRole(String roleid, String rolename) {
		this.roleid = roleid;
		this.rolename = rolename;
	}

	/** full constructor */
	public BssSysRole(String roleid, String rolename, String roledes,
			String vchar1, String vchar2, String vchar3, String vchar4,
			String vchar5, String vchar6) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.roledes = roledes;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
		this.vchar6 = vchar6;
	}

	// Property accessors

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getRoledes() {
		return this.roledes;
	}

	public void setRoledes(String roledes) {
		this.roledes = roledes;
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

	public String getVchar4() {
		return this.vchar4;
	}

	public void setVchar4(String vchar4) {
		this.vchar4 = vchar4;
	}

	public String getVchar5() {
		return this.vchar5;
	}

	public void setVchar5(String vchar5) {
		this.vchar5 = vchar5;
	}

	public String getVchar6() {
		return this.vchar6;
	}

	public void setVchar6(String vchar6) {
		this.vchar6 = vchar6;
	}

}