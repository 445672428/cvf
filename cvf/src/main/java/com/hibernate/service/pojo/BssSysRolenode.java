package com.hibernate.service.pojo;

/**
 * BssSysRolenode entity. @author MyEclipse Persistence Tools
 */

public class BssSysRolenode implements java.io.Serializable {

	// Fields

	private String rnid;
	private String rsid;
	private String nodeid;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;

	// Constructors

	/** default constructor */
	public BssSysRolenode() {
	}

	/** minimal constructor */
	public BssSysRolenode(String rnid, String rsid, String nodeid) {
		this.rnid = rnid;
		this.rsid = rsid;
		this.nodeid = nodeid;
	}

	/** full constructor */
	public BssSysRolenode(String rnid, String rsid, String nodeid,
			String vchar1, String vchar2, String vchar3, String vchar4) {
		this.rnid = rnid;
		this.rsid = rsid;
		this.nodeid = nodeid;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
	}

	// Property accessors

	public String getRnid() {
		return this.rnid;
	}

	public void setRnid(String rnid) {
		this.rnid = rnid;
	}

	public String getRsid() {
		return this.rsid;
	}

	public void setRsid(String rsid) {
		this.rsid = rsid;
	}

	public String getNodeid() {
		return this.nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
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