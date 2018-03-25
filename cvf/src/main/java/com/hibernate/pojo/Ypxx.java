package com.hibernate.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Ypxx entity. @author MyEclipse Persistence Tools
 */

public class Ypxx implements java.io.Serializable {

	// Fields

	private String id;
	private String bm;
	private String scqymc;
	private String spmc;
	private Double zbjg;
	private String zpdz;
	private String pzwh;
	private Timestamp pzwhyxq;
	private String jky;
	private String bzcz;
	private String bzdw;
	private Double lsjg;
	private String lsjgcc;
	private String zlcc;
	private String zlccsm;
	private String ypjybg;
	private String ypjybgbm;
	private Timestamp ypjybgyxq;
	private String cpsm;
	private String jyzt;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String dw;
	private String mc;
	private String jx;
	private String gg;
	private String zhxs;
	private String pinyin;
	private String lb;
	private Set gysypmls = new HashSet(0);
	private Set yyypmls = new HashSet(0);
	private Set yycgdmxes = new HashSet(0);
	private Set yybusiness2015s = new HashSet(0);
	private Set yybusiness2014s = new HashSet(0);
	private Set yybusinesses = new HashSet(0);
	private Set gysypmlControls = new HashSet(0);
	private Set yycgdmx2014s = new HashSet(0);

	// Constructors

	/** default constructor */
	public Ypxx() {
	}

	/** minimal constructor */
	public Ypxx(String id, String bm, String scqymc, String spmc, Double zbjg,
			String jyzt) {
		this.id = id;
		this.bm = bm;
		this.scqymc = scqymc;
		this.spmc = spmc;
		this.zbjg = zbjg;
		this.jyzt = jyzt;
	}

	/** full constructor */
	public Ypxx(String id, String bm, String scqymc, String spmc, Double zbjg,
			String zpdz, String pzwh, Timestamp pzwhyxq, String jky,
			String bzcz, String bzdw, Double lsjg, String lsjgcc, String zlcc,
			String zlccsm, String ypjybg, String ypjybgbm, Timestamp ypjybgyxq,
			String cpsm, String jyzt, String vchar1, String vchar2,
			String vchar3, String dw, String mc, String jx, String gg,
			String zhxs, String pinyin, String lb, Set gysypmls, Set yyypmls,
			Set yycgdmxes, Set yybusiness2015s, Set yybusiness2014s,
			Set yybusinesses, Set gysypmlControls, Set yycgdmx2014s) {
		this.id = id;
		this.bm = bm;
		this.scqymc = scqymc;
		this.spmc = spmc;
		this.zbjg = zbjg;
		this.zpdz = zpdz;
		this.pzwh = pzwh;
		this.pzwhyxq = pzwhyxq;
		this.jky = jky;
		this.bzcz = bzcz;
		this.bzdw = bzdw;
		this.lsjg = lsjg;
		this.lsjgcc = lsjgcc;
		this.zlcc = zlcc;
		this.zlccsm = zlccsm;
		this.ypjybg = ypjybg;
		this.ypjybgbm = ypjybgbm;
		this.ypjybgyxq = ypjybgyxq;
		this.cpsm = cpsm;
		this.jyzt = jyzt;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.dw = dw;
		this.mc = mc;
		this.jx = jx;
		this.gg = gg;
		this.zhxs = zhxs;
		this.pinyin = pinyin;
		this.lb = lb;
		this.gysypmls = gysypmls;
		this.yyypmls = yyypmls;
		this.yycgdmxes = yycgdmxes;
		this.yybusiness2015s = yybusiness2015s;
		this.yybusiness2014s = yybusiness2014s;
		this.yybusinesses = yybusinesses;
		this.gysypmlControls = gysypmlControls;
		this.yycgdmx2014s = yycgdmx2014s;
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

	public String getScqymc() {
		return this.scqymc;
	}

	public void setScqymc(String scqymc) {
		this.scqymc = scqymc;
	}

	public String getSpmc() {
		return this.spmc;
	}

	public void setSpmc(String spmc) {
		this.spmc = spmc;
	}

	public Double getZbjg() {
		return this.zbjg;
	}

	public void setZbjg(Double zbjg) {
		this.zbjg = zbjg;
	}

	public String getZpdz() {
		return this.zpdz;
	}

	public void setZpdz(String zpdz) {
		this.zpdz = zpdz;
	}

	public String getPzwh() {
		return this.pzwh;
	}

	public void setPzwh(String pzwh) {
		this.pzwh = pzwh;
	}

	public Timestamp getPzwhyxq() {
		return this.pzwhyxq;
	}

	public void setPzwhyxq(Timestamp pzwhyxq) {
		this.pzwhyxq = pzwhyxq;
	}

	public String getJky() {
		return this.jky;
	}

	public void setJky(String jky) {
		this.jky = jky;
	}

	public String getBzcz() {
		return this.bzcz;
	}

	public void setBzcz(String bzcz) {
		this.bzcz = bzcz;
	}

	public String getBzdw() {
		return this.bzdw;
	}

	public void setBzdw(String bzdw) {
		this.bzdw = bzdw;
	}

	public Double getLsjg() {
		return this.lsjg;
	}

	public void setLsjg(Double lsjg) {
		this.lsjg = lsjg;
	}

	public String getLsjgcc() {
		return this.lsjgcc;
	}

	public void setLsjgcc(String lsjgcc) {
		this.lsjgcc = lsjgcc;
	}

	public String getZlcc() {
		return this.zlcc;
	}

	public void setZlcc(String zlcc) {
		this.zlcc = zlcc;
	}

	public String getZlccsm() {
		return this.zlccsm;
	}

	public void setZlccsm(String zlccsm) {
		this.zlccsm = zlccsm;
	}

	public String getYpjybg() {
		return this.ypjybg;
	}

	public void setYpjybg(String ypjybg) {
		this.ypjybg = ypjybg;
	}

	public String getYpjybgbm() {
		return this.ypjybgbm;
	}

	public void setYpjybgbm(String ypjybgbm) {
		this.ypjybgbm = ypjybgbm;
	}

	public Timestamp getYpjybgyxq() {
		return this.ypjybgyxq;
	}

	public void setYpjybgyxq(Timestamp ypjybgyxq) {
		this.ypjybgyxq = ypjybgyxq;
	}

	public String getCpsm() {
		return this.cpsm;
	}

	public void setCpsm(String cpsm) {
		this.cpsm = cpsm;
	}

	public String getJyzt() {
		return this.jyzt;
	}

	public void setJyzt(String jyzt) {
		this.jyzt = jyzt;
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

	public String getDw() {
		return this.dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
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

	public String getGg() {
		return this.gg;
	}

	public void setGg(String gg) {
		this.gg = gg;
	}

	public String getZhxs() {
		return this.zhxs;
	}

	public void setZhxs(String zhxs) {
		this.zhxs = zhxs;
	}

	public String getPinyin() {
		return this.pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getLb() {
		return this.lb;
	}

	public void setLb(String lb) {
		this.lb = lb;
	}

	public Set getGysypmls() {
		return this.gysypmls;
	}

	public void setGysypmls(Set gysypmls) {
		this.gysypmls = gysypmls;
	}

	public Set getYyypmls() {
		return this.yyypmls;
	}

	public void setYyypmls(Set yyypmls) {
		this.yyypmls = yyypmls;
	}

	public Set getYycgdmxes() {
		return this.yycgdmxes;
	}

	public void setYycgdmxes(Set yycgdmxes) {
		this.yycgdmxes = yycgdmxes;
	}

	public Set getYybusiness2015s() {
		return this.yybusiness2015s;
	}

	public void setYybusiness2015s(Set yybusiness2015s) {
		this.yybusiness2015s = yybusiness2015s;
	}

	public Set getYybusiness2014s() {
		return this.yybusiness2014s;
	}

	public void setYybusiness2014s(Set yybusiness2014s) {
		this.yybusiness2014s = yybusiness2014s;
	}

	public Set getYybusinesses() {
		return this.yybusinesses;
	}

	public void setYybusinesses(Set yybusinesses) {
		this.yybusinesses = yybusinesses;
	}

	public Set getGysypmlControls() {
		return this.gysypmlControls;
	}

	public void setGysypmlControls(Set gysypmlControls) {
		this.gysypmlControls = gysypmlControls;
	}

	public Set getYycgdmx2014s() {
		return this.yycgdmx2014s;
	}

	public void setYycgdmx2014s(Set yycgdmx2014s) {
		this.yycgdmx2014s = yycgdmx2014s;
	}

}