package com.hibernate.pojo;

/**
 * BssSysRoleoperate entity. @author MyEclipse Persistence Tools
 */

public class BssSysRoleoperate implements java.io.Serializable {

	// Fields

	private String roid;
	private String rmid;
	private String operateid;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;

	// Constructors

	/** default constructor */
	public BssSysRoleoperate() {
	}

	/** minimal constructor */
	public BssSysRoleoperate(String roid, String rmid, String operateid) {
		this.roid = roid;
		this.rmid = rmid;
		this.operateid = operateid;
	}

	/** full constructor */
	public BssSysRoleoperate(String roid, String rmid, String operateid,
			String vchar1, String vchar2, String vchar3, String vchar4) {
		this.roid = roid;
		this.rmid = rmid;
		this.operateid = operateid;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
	}

	// Property accessors

	public String getRoid() {
		return this.roid;
	}

	public void setRoid(String roid) {
		this.roid = roid;
	}

	public String getRmid() {
		return this.rmid;
	}

	public void setRmid(String rmid) {
		this.rmid = rmid;
	}

	public String getOperateid() {
		return this.operateid;
	}

	public void setOperateid(String operateid) {
		this.operateid = operateid;
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