package com.hibernate.pojo;

/**
 * BssSysRolemodule entity. @author MyEclipse Persistence Tools
 */

public class BssSysRolemodule implements java.io.Serializable {

	// Fields

	private String rmid;
	private String rnid;
	private String moduleid;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;

	// Constructors

	/** default constructor */
	public BssSysRolemodule() {
	}

	/** minimal constructor */
	public BssSysRolemodule(String rmid, String rnid, String moduleid) {
		this.rmid = rmid;
		this.rnid = rnid;
		this.moduleid = moduleid;
	}

	/** full constructor */
	public BssSysRolemodule(String rmid, String rnid, String moduleid,
			String vchar1, String vchar2, String vchar3, String vchar4) {
		this.rmid = rmid;
		this.rnid = rnid;
		this.moduleid = moduleid;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
	}

	// Property accessors

	public String getRmid() {
		return this.rmid;
	}

	public void setRmid(String rmid) {
		this.rmid = rmid;
	}

	public String getRnid() {
		return this.rnid;
	}

	public void setRnid(String rnid) {
		this.rnid = rnid;
	}

	public String getModuleid() {
		return this.moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
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

}