package com.hibernate.service.pojo;

/**
 * BssSysOperate entity. @author MyEclipse Persistence Tools
 */

public class BssSysOperate implements java.io.Serializable {

	// Fields

	private String operateid;
	private String operatename;
	private String operatecode;
	private String method;
	private String moduleid;
	private String icon;
	private Integer showorder;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;
	private String vchar6;

	// Constructors

	/** default constructor */
	public BssSysOperate() {
	}

	/** minimal constructor */
	public BssSysOperate(String operateid, String operatename, Integer showorder) {
		this.operateid = operateid;
		this.operatename = operatename;
		this.showorder = showorder;
	}

	/** full constructor */
	public BssSysOperate(String operateid, String operatename,
			String operatecode, String method, String moduleid, String icon,
			Integer showorder, String vchar1, String vchar2, String vchar3,
			String vchar4, String vchar5, String vchar6) {
		this.operateid = operateid;
		this.operatename = operatename;
		this.operatecode = operatecode;
		this.method = method;
		this.moduleid = moduleid;
		this.icon = icon;
		this.showorder = showorder;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
		this.vchar6 = vchar6;
	}

	// Property accessors

	public String getOperateid() {
		return this.operateid;
	}

	public void setOperateid(String operateid) {
		this.operateid = operateid;
	}

	public String getOperatename() {
		return this.operatename;
	}

	public void setOperatename(String operatename) {
		this.operatename = operatename;
	}

	public String getOperatecode() {
		return this.operatecode;
	}

	public void setOperatecode(String operatecode) {
		this.operatecode = operatecode;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getModuleid() {
		return this.moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
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