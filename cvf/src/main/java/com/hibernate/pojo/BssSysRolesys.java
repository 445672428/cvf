package com.hibernate.pojo;

/**
 * BssSysRolesys entity. @author MyEclipse Persistence Tools
 */

public class BssSysRolesys implements java.io.Serializable {

	// Fields

	private String rsid;
	private String roleid;
	private String sysid;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;

	// Constructors

	/** default constructor */
	public BssSysRolesys() {
	}

	/** minimal constructor */
	public BssSysRolesys(String rsid, String roleid, String sysid) {
		this.rsid = rsid;
		this.roleid = roleid;
		this.sysid = sysid;
	}

	/** full constructor */
	public BssSysRolesys(String rsid, String roleid, String sysid,
			String vchar1, String vchar2, String vchar3, String vchar4) {
		this.rsid = rsid;
		this.roleid = roleid;
		this.sysid = sysid;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
	}

	// Property accessors

	public String getRsid() {
		return this.rsid;
	}

	public void setRsid(String rsid) {
		this.rsid = rsid;
	}

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getSysid() {
		return this.sysid;
	}

	public void setSysid(String sysid) {
		this.sysid = sysid;
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