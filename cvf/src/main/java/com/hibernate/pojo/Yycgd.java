package com.hibernate.pojo;

import java.sql.Timestamp;

/**
 * Yycgd entity. @author MyEclipse Persistence Tools
 */

public class Yycgd implements java.io.Serializable {

	// Fields

	private String id;
	private Useryy useryy;
	private String bm;
	private String mc;
	private String lxr;
	private String lxdh;
	private String cjr;
	private Timestamp cjtime;
	private Timestamp tjtime;
	private String bz;
	private String zt;
	private String shyj;
	private Timestamp shtime;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;
	private Timestamp xgtime;

	// Constructors

	/** default constructor */
	public Yycgd() {
	}

	/** minimal constructor */
	public Yycgd(String id, Useryy useryy, String bm, String mc,
			Timestamp cjtime, String zt) {
		this.id = id;
		this.useryy = useryy;
		this.bm = bm;
		this.mc = mc;
		this.cjtime = cjtime;
		this.zt = zt;
	}

	/** full constructor */
	public Yycgd(String id, Useryy useryy, String bm, String mc, String lxr,
			String lxdh, String cjr, Timestamp cjtime, Timestamp tjtime,
			String bz, String zt, String shyj, Timestamp shtime, String vchar1,
			String vchar2, String vchar3, String vchar4, String vchar5,
			Timestamp xgtime) {
		this.id = id;
		this.useryy = useryy;
		this.bm = bm;
		this.mc = mc;
		this.lxr = lxr;
		this.lxdh = lxdh;
		this.cjr = cjr;
		this.cjtime = cjtime;
		this.tjtime = tjtime;
		this.bz = bz;
		this.zt = zt;
		this.shyj = shyj;
		this.shtime = shtime;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
		this.xgtime = xgtime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Useryy getUseryy() {
		return this.useryy;
	}

	public void setUseryy(Useryy useryy) {
		this.useryy = useryy;
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

	public String getShyj() {
		return this.shyj;
	}

	public void setShyj(String shyj) {
		this.shyj = shyj;
	}

	public Timestamp getShtime() {
		return this.shtime;
	}

	public void setShtime(Timestamp shtime) {
		this.shtime = shtime;
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

	public Timestamp getXgtime() {
		return this.xgtime;
	}

	public void setXgtime(Timestamp xgtime) {
		this.xgtime = xgtime;
	}

}