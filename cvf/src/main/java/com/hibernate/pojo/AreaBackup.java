package com.hibernate.pojo;

/**
 * AreaBackup entity. @author MyEclipse Persistence Tools
 */

public class AreaBackup implements java.io.Serializable {

	// Fields

	private String areaid;
	private String areacode;
	private String areaname;
	private String arealevel;
	private String areafullname;
	private String parentid;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String isused;

	// Constructors

	/** default constructor */
	public AreaBackup() {
	}

	/** minimal constructor */
	public AreaBackup(String areaid, String areaname, String arealevel,
			String parentid) {
		this.areaid = areaid;
		this.areaname = areaname;
		this.arealevel = arealevel;
		this.parentid = parentid;
	}

	/** full constructor */
	public AreaBackup(String areaid, String areacode, String areaname,
			String arealevel, String areafullname, String parentid,
			String vchar1, String vchar2, String vchar3, String isused) {
		this.areaid = areaid;
		this.areacode = areacode;
		this.areaname = areaname;
		this.arealevel = arealevel;
		this.areafullname = areafullname;
		this.parentid = parentid;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.isused = isused;
	}

	// Property accessors

	public String getAreaid() {
		return this.areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getAreaname() {
		return this.areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getArealevel() {
		return this.arealevel;
	}

	public void setArealevel(String arealevel) {
		this.arealevel = arealevel;
	}

	public String getAreafullname() {
		return this.areafullname;
	}

	public void setAreafullname(String areafullname) {
		this.areafullname = areafullname;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
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

	public String getIsused() {
		return this.isused;
	}

	public void setIsused(String isused) {
		this.isused = isused;
	}

}