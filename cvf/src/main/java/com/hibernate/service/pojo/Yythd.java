package com.hibernate.service.pojo;

import java.sql.Timestamp;

/**
 * Yythd entity. @author MyEclipse Persistence Tools
 */

public class Yythd implements java.io.Serializable {

	// Fields

	private String id;
	private String bm;
	private String mc;
	private String useryyid;
	private String lxr;
	private String lxdh;
	private String cjr;
	private Timestamp cjtime;
	private Timestamp xgtime;
	private Timestamp tjtime;
	private String bz;
	private String zt;
	private String vchar1;
	private String vchar2;
	private String vchar3;

	// Constructors

	/** default constructor */
	public Yythd() {
	}

	/** minimal constructor */
	public Yythd(String id) {
		this.id = id;
	}

	/** full constructor */
	public Yythd(String id, String bm, String mc, String useryyid, String lxr,
			String lxdh, String cjr, Timestamp cjtime, Timestamp xgtime,
			Timestamp tjtime, String bz, String zt, String vchar1,
			String vchar2, String vchar3) {
		this.id = id;
		this.bm = bm;
		this.mc = mc;
		this.useryyid = useryyid;
		this.lxr = lxr;
		this.lxdh = lxdh;
		this.cjr = cjr;
		this.cjtime = cjtime;
		this.xgtime = xgtime;
		this.tjtime = tjtime;
		this.bz = bz;
		this.zt = zt;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBm() {
		return this.bm;
	}

	public void setBm(String bm) {
		this.bm = bm;
	}

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getUseryyid() {
		return this.useryyid;
	}

	public void setUseryyid(String useryyid) {
		this.useryyid = useryyid;
	}

	public String getLxr() {
		return this.lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public String getLxdh() {
		return this.lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getCjr() {
		return this.cjr;
	}

	public void setCjr(String cjr) {
		this.cjr = cjr;
	}

	public Timestamp getCjtime() {
		return this.cjtime;
	}

	public void setCjtime(Timestamp cjtime) {
		this.cjtime = cjtime;
	}

	public Timestamp getXgtime() {
		return this.xgtime;
	}

	public void setXgtime(Timestamp xgtime) {
		this.xgtime = xgtime;
	}

	public Timestamp getTjtime() {
		return this.tjtime;
	}

	public void setTjtime(Timestamp tjtime) {
		this.tjtime = tjtime;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getZt() {
		return this.zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
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

}