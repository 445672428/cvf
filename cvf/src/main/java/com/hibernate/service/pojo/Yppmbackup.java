package com.hibernate.service.pojo;

/**
 * Yppmbackup entity. @author MyEclipse Persistence Tools
 */

public class Yppmbackup implements java.io.Serializable {

	// Fields

	private String id;
	private String bm;
	private String mc;
	private String jx;
	private String dw;
	private String zhxs;
	private String lb;
	private String zt;
	private String zl;
	private String hl;
	private String yb;
	private String ybbm;
	private String bz;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String gg;

	// Constructors

	/** default constructor */
	public Yppmbackup() {
	}

	/** minimal constructor */
	public Yppmbackup(String id, String bm, String mc, String jx, String zhxs) {
		this.id = id;
		this.bm = bm;
		this.mc = mc;
		this.jx = jx;
		this.zhxs = zhxs;
	}

	/** full constructor */
	public Yppmbackup(String id, String bm, String mc, String jx, String dw,
			String zhxs, String lb, String zt, String zl, String hl, String yb,
			String ybbm, String bz, String vchar1, String vchar2,
			String vchar3, String gg) {
		this.id = id;
		this.bm = bm;
		this.mc = mc;
		this.jx = jx;
		this.dw = dw;
		this.zhxs = zhxs;
		this.lb = lb;
		this.zt = zt;
		this.zl = zl;
		this.hl = hl;
		this.yb = yb;
		this.ybbm = ybbm;
		this.bz = bz;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.gg = gg;
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

	public String getJx() {
		return this.jx;
	}

	public void setJx(String jx) {
		this.jx = jx;
	}

	public String getDw() {
		return this.dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
	}

	public String getZhxs() {
		return this.zhxs;
	}

	public void setZhxs(String zhxs) {
		this.zhxs = zhxs;
	}

	public String getLb() {
		return this.lb;
	}

	public void setLb(String lb) {
		this.lb = lb;
	}

	public String getZt() {
		return this.zt;
	}

	public void setZt(String zt) {
		this.zt = zt;
	}

	public String getZl() {
		return this.zl;
	}

	public void setZl(String zl) {
		this.zl = zl;
	}

	public String getHl() {
		return this.hl;
	}

	public void setHl(String hl) {
		this.hl = hl;
	}

	public String getYb() {
		return this.yb;
	}

	public void setYb(String yb) {
		this.yb = yb;
	}

	public String getYbbm() {
		return this.ybbm;
	}

	public void setYbbm(String ybbm) {
		this.ybbm = ybbm;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
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

	public String getGg() {
		return this.gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

}