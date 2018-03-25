package com.hibernate.pojo;

/**
 * Gysypml entity. @author MyEclipse Persistence Tools
 */

public class Gysypml implements java.io.Serializable {

	// Fields

	private String id;
	private Ypxx ypxx;
	private String usergysid;
	private String vchar1;
	private String vchar2;

	// Constructors

	/** default constructor */
	public Gysypml() {
	}

	/** minimal constructor */
	public Gysypml(String id, Ypxx ypxx, String usergysid) {
		this.id = id;
		this.ypxx = ypxx;
		this.usergysid = usergysid;
	}

	/** full constructor */
	public Gysypml(String id, Ypxx ypxx, String usergysid, String vchar1,
			String vchar2) {
		this.id = id;
		this.ypxx = ypxx;
		this.usergysid = usergysid;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ypxx getYpxx() {
		return this.ypxx;
	}

	public void setYpxx(Ypxx ypxx) {
		this.ypxx = ypxx;
	}

	public String getUsergysid() {
		return this.usergysid;
	}

	public void setUsergysid(String usergysid) {
		this.usergysid = usergysid;
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

}