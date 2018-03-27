package com.hibernate.pojo;

/**
 * BssSysModule entity. @author MyEclipse Persistence Tools
 */

public class BssSysModule implements java.io.Serializable {

	// Fields

	private String moduleid;
	private String sysid;
	private String name;
	private String parentid;
	private String url;
	private String icon;
	private Integer showorder;
	private String isused;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;
	private String vchar6;

	// Constructors

	/** default constructor */
	public BssSysModule() {
	}

	/** minimal constructor */
	public BssSysModule(String moduleid, String sysid, String name,
			String parentid, Integer showorder, String isused) {
		this.moduleid = moduleid;
		this.sysid = sysid;
		this.name = name;
		this.parentid = parentid;
		this.showorder = showorder;
		this.isused = isused;
	}

	/** full constructor */
	public BssSysModule(String moduleid, String sysid, String name,
			String parentid, String url, String icon, Integer showorder,
			String isused, String vchar1, String vchar2, String vchar3,
			String vchar4, String vchar5, String vchar6) {
		this.moduleid = moduleid;
		this.sysid = sysid;
		this.name = name;
		this.parentid = parentid;
		this.url = url;
		this.icon = icon;
		this.showorder = showorder;
		this.isused = isused;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
		this.vchar6 = vchar6;
	}

	// Property accessors

	public String getModuleid() {
		return this.moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}

	public String getSysid() {
		return this.sysid;
	}

	public void setSysid(String sysid) {
		this.sysid = sysid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getShoworder() {
		return this.showorder;
	}

	public void setShoworder(Integer showorder) {
		this.showorder = showorder;
	}

	public String getIsused() {
		return this.isused;
	}

	public void setIsused(String isused) {
		this.isused = isused;
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