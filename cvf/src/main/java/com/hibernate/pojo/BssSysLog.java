package com.hibernate.pojo;

/**
 * BssSysLog entity. @author MyEclipse Persistence Tools
 */

public class BssSysLog implements java.io.Serializable {

	// Fields

	private String logid;
	private String username;
	private String truename;
	private String clientip;
	private String opertype;
	private String modulename;
	private String opercontent;
	private String operdate;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;
	private String vchar6;

	// Constructors

	/** default constructor */
	public BssSysLog() {
	}

	/** minimal constructor */
	public BssSysLog(String logid, String username, String truename,
			String opertype, String modulename, String operdate) {
		this.logid = logid;
		this.username = username;
		this.truename = truename;
		this.opertype = opertype;
		this.modulename = modulename;
		this.operdate = operdate;
	}

	/** full constructor */
	public BssSysLog(String logid, String username, String truename,
			String clientip, String opertype, String modulename,
			String opercontent, String operdate, String vchar1, String vchar2,
			String vchar3, String vchar4, String vchar5, String vchar6) {
		this.logid = logid;
		this.username = username;
		this.truename = truename;
		this.clientip = clientip;
		this.opertype = opertype;
		this.modulename = modulename;
		this.opercontent = opercontent;
		this.operdate = operdate;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
		this.vchar6 = vchar6;
	}

	// Property accessors

	public String getLogid() {
		return this.logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getClientip() {
		return this.clientip;
	}

	public void setClientip(String clientip) {
		this.clientip = clientip;
	}

	public String getOpertype() {
		return this.opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public String getModulename() {
		return this.modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public String getOpercontent() {
		return this.opercontent;
	}

	public void setOpercontent(String opercontent) {
		this.opercontent = opercontent;
	}

	public String getOperdate() {
		return this.operdate;
	}

	public void setOperdate(String operdate) {
		this.operdate = operdate;
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