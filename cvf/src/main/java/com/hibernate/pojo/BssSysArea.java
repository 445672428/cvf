package com.hibernate.pojo;

/**
 * BssSysArea entity. @author MyEclipse Persistence Tools
 */

public class BssSysArea implements java.io.Serializable {

	// Fields

	private String areaid;
	private String areaname;
	private Integer arealevel;
	private String areafullname;
	private String parentid;
	private String shortname;
	private String isunit;
	private String lastupdate;
	private String yzcode;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;
	private String vchar6;

	// Constructors

	/** default constructor */
	public BssSysArea() {
	}

	/** minimal constructor */
	public BssSysArea(String areaid, String areaname, Integer arealevel) {
		this.areaid = areaid;
		this.areaname = areaname;
		this.arealevel = arealevel;
	}

	/** full constructor */
	public BssSysArea(String areaid, String areaname, Integer arealevel,
			String areafullname, String parentid, String shortname,
			String isunit, String lastupdate, String yzcode, String vchar1,
			String vchar2, String vchar3, String vchar4, String vchar5,
			String vchar6) {
		this.areaid = areaid;
		this.areaname = areaname;
		this.arealevel = arealevel;
		this.areafullname = areafullname;
		this.parentid = parentid;
		this.shortname = shortname;
		this.isunit = isunit;
		this.lastupdate = lastupdate;
		this.yzcode = yzcode;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
		this.vchar6 = vchar6;
	}

	// Property accessors

	public String getAreaid() {
		return this.areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public String getAreaname() {
		return this.areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public Integer getArealevel() {
		return this.arealevel;
	}

	public void setArealevel(Integer arealevel) {
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

	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getIsunit() {
		return this.isunit;
	}

	public void setIsunit(String isunit) {
		this.isunit = isunit;
	}

	public String getLastupdate() {
		return this.lastupdate;
	}

	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}

	public String getYzcode() {
		return this.yzcode;
	}

	public void setYzcode(String yzcode) {
		this.yzcode = yzcode;
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