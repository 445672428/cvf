package com.hibernate.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Usergys entity. @author MyEclipse Persistence Tools
 */

public class Usergys implements java.io.Serializable {

	// Fields

	private String id;
	private String mc;
	private String lb;
	private String xkz;
	private String xkzyxq;
	private String lxr;
	private String dh;
	private String jyfw;
	private String zcdz;
	private String lxdz;
	private String yzbm;
	private String zzc;
	private String cz;
	private String frmc;
	private String frsfz;
	private String zczj;
	private String xse;
	private String dzyx;
	private String wz;
	private String dmzh;
	private String dmzhyxq;
	private String yyzz;
	private String yyzzyxq;
	private String xyz;
	private String xyzbm;
	private String xyzyxq;
	private String gdzc;
	private String jj;
	private String bz;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;
	private Set usergysareas = new HashSet(0);
	private Set yycgdmxes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Usergys() {
	}

	/** minimal constructor */
	public Usergys(String id, String mc) {
		this.id = id;
		this.mc = mc;
	}

	/** full constructor */
	public Usergys(String id, String mc, String lb, String xkz, String xkzyxq,
			String lxr, String dh, String jyfw, String zcdz, String lxdz,
			String yzbm, String zzc, String cz, String frmc, String frsfz,
			String zczj, String xse, String dzyx, String wz, String dmzh,
			String dmzhyxq, String yyzz, String yyzzyxq, String xyz,
			String xyzbm, String xyzyxq, String gdzc, String jj, String bz,
			String vchar1, String vchar2, String vchar3, String vchar4,
			String vchar5, Set usergysareas, Set yycgdmxes) {
		this.id = id;
		this.mc = mc;
		this.lb = lb;
		this.xkz = xkz;
		this.xkzyxq = xkzyxq;
		this.lxr = lxr;
		this.dh = dh;
		this.jyfw = jyfw;
		this.zcdz = zcdz;
		this.lxdz = lxdz;
		this.yzbm = yzbm;
		this.zzc = zzc;
		this.cz = cz;
		this.frmc = frmc;
		this.frsfz = frsfz;
		this.zczj = zczj;
		this.xse = xse;
		this.dzyx = dzyx;
		this.wz = wz;
		this.dmzh = dmzh;
		this.dmzhyxq = dmzhyxq;
		this.yyzz = yyzz;
		this.yyzzyxq = yyzzyxq;
		this.xyz = xyz;
		this.xyzbm = xyzbm;
		this.xyzyxq = xyzyxq;
		this.gdzc = gdzc;
		this.jj = jj;
		this.bz = bz;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
		this.usergysareas = usergysareas;
		this.yycgdmxes = yycgdmxes;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMc() {
		return this.mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getLb() {
		return this.lb;
	}

	public void setLb(String lb) {
		this.lb = lb;
	}

	public String getXkz() {
		return this.xkz;
	}

	public void setXkz(String xkz) {
		this.xkz = xkz;
	}

	public String getXkzyxq() {
		return this.xkzyxq;
	}

	public void setXkzyxq(String xkzyxq) {
		this.xkzyxq = xkzyxq;
	}

	public String getLxr() {
		return this.lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public String getDh() {
		return this.dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	public String getJyfw() {
		return this.jyfw;
	}

	public void setJyfw(String jyfw) {
		this.jyfw = jyfw;
	}

	public String getZcdz() {
		return this.zcdz;
	}

	public void setZcdz(String zcdz) {
		this.zcdz = zcdz;
	}

	public String getLxdz() {
		return this.lxdz;
	}

	public void setLxdz(String lxdz) {
		this.lxdz = lxdz;
	}

	public String getYzbm() {
		return this.yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	public String getZzc() {
		return this.zzc;
	}

	public void setZzc(String zzc) {
		this.zzc = zzc;
	}

	public String getCz() {
		return this.cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
	}

	public String getFrmc() {
		return this.frmc;
	}

	public void setFrmc(String frmc) {
		this.frmc = frmc;
	}

	public String getFrsfz() {
		return this.frsfz;
	}

	public void setFrsfz(String frsfz) {
		this.frsfz = frsfz;
	}

	public String getZczj() {
		return this.zczj;
	}

	public void setZczj(String zczj) {
		this.zczj = zczj;
	}

	public String getXse() {
		return this.xse;
	}

	public void setXse(String xse) {
		this.xse = xse;
	}

	public String getDzyx() {
		return this.dzyx;
	}

	public void setDzyx(String dzyx) {
		this.dzyx = dzyx;
	}

	public String getWz() {
		return this.wz;
	}

	public void setWz(String wz) {
		this.wz = wz;
	}

	public String getDmzh() {
		return this.dmzh;
	}

	public void setDmzh(String dmzh) {
		this.dmzh = dmzh;
	}

	public String getDmzhyxq() {
		return this.dmzhyxq;
	}

	public void setDmzhyxq(String dmzhyxq) {
		this.dmzhyxq = dmzhyxq;
	}

	public String getYyzz() {
		return this.yyzz;
	}

	public void setYyzz(String yyzz) {
		this.yyzz = yyzz;
	}

	public String getYyzzyxq() {
		return this.yyzzyxq;
	}

	public void setYyzzyxq(String yyzzyxq) {
		this.yyzzyxq = yyzzyxq;
	}

	public String getXyz() {
		return this.xyz;
	}

	public void setXyz(String xyz) {
		this.xyz = xyz;
	}

	public String getXyzbm() {
		return this.xyzbm;
	}

	public void setXyzbm(String xyzbm) {
		this.xyzbm = xyzbm;
	}

	public String getXyzyxq() {
		return this.xyzyxq;
	}

	public void setXyzyxq(String xyzyxq) {
		this.xyzyxq = xyzyxq;
	}

	public String getGdzc() {
		return this.gdzc;
	}

	public void setGdzc(String gdzc) {
		this.gdzc = gdzc;
	}

	public String getJj() {
		return this.jj;
	}

	public void setJj(String jj) {
		this.jj = jj;
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

	public Set getUsergysareas() {
		return this.usergysareas;
	}

	public void setUsergysareas(Set usergysareas) {
		this.usergysareas = usergysareas;
	}

	public Set getYycgdmxes() {
		return this.yycgdmxes;
	}

	public void setYycgdmxes(Set yycgdmxes) {
		this.yycgdmxes = yycgdmxes;
	}

}