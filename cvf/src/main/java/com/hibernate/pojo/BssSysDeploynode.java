package com.hibernate.pojo;

/**
 * BssSysDeploynode entity. @author MyEclipse Persistence Tools
 */

public class BssSysDeploynode implements java.io.Serializable {

	// Fields

	private String nodeid;
	private String name;
	private String sysid;
	private String url;
	private String icon;
	private Integer showorder;
	private String vchar1;
	private String vchar6;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;

	// Constructors

	/** default constructor */
	public BssSysDeploynode() {
	}

	/** minimal constructor */
	public BssSysDeploynode(String nodeid, String name, String sysid,
			String url, Integer showorder) {
		this.nodeid = nodeid;
		this.name = name;
		this.sysid = sysid;
		this.url = url;
		this.showorder = showorder;
	}

	/** full constructor */
	public BssSysDeploynode(String nodeid, String name, String sysid,
			String url, String icon, Integer showorder, String vchar1,
			String vchar6, String vchar2, String vchar3, String vchar4,
			String vchar5) {
		this.nodeid = nodeid;
		this.name = name;
		this.sysid = sysid;
		this.url = url;
		this.icon = icon;
		this.showorder = showorder;
		this.vchar1 = vchar1;
		this.vchar6 = vchar6;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
	}

	// Property accessors

	public String getNodeid() {
		return this.nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSysid() {
		return this.sysid;
	}

	public void setSysid(String sysid) {
		this.sysid = sysid;
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

	public String getVchar1() {
		return this.vchar1;
	}

	public void setVchar1(String vchar1) {
		this.vchar1 = vchar1;
	}

	public String getVchar6() {
		return this.vchar6;
	}

	public void setVchar6(String vchar6) {
		this.vchar6 = vchar6;
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

}