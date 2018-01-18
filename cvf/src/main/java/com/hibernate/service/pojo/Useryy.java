package com.hibernate.service.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Useryy entity. @author MyEclipse Persistence Tools
 */

public class Useryy implements java.io.Serializable {

	// Fields

	private String id;
	private String mc;
	private String dz;
	private String yzbm;
	private String dq;
	private String jb;
	private String cws;
	private String fyljg;
	private String dh;
	private String yjkdh;
	private String lb;
	private String ypsr;
	private String ywsr;
	private String cz;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;
	private Set yybusiness2014s = new HashSet(0);
	private Set yycgds = new HashSet(0);
	private Set yybusinesses = new HashSet(0);
	private Set yybusiness2015s = new HashSet(0);

	// Constructors

	/** default constructor */
	public Useryy() {
	}

	/** minimal constructor */
	public Useryy(String id, String mc) {
		this.id = id;
		this.mc = mc;
	}

	/** full constructor */
	public Useryy(String id, String mc, String dz, String yzbm, String dq,
			String jb, String cws, String fyljg, String dh, String yjkdh,
			String lb, String ypsr, String ywsr, String cz, String vchar1,
			String vchar2, String vchar3, String vchar4, String vchar5,
			Set yybusiness2014s, Set yycgds, Set yybusinesses,
			Set yybusiness2015s) {
		this.id = id;
		this.mc = mc;
		this.dz = dz;
		this.yzbm = yzbm;
		this.dq = dq;
		this.jb = jb;
		this.cws = cws;
		this.fyljg = fyljg;
		this.dh = dh;
		this.yjkdh = yjkdh;
		this.lb = lb;
		this.ypsr = ypsr;
		this.ywsr = ywsr;
		this.cz = cz;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
		this.yybusiness2014s = yybusiness2014s;
		this.yycgds = yycgds;
		this.yybusinesses = yybusinesses;
		this.yybusiness2015s = yybusiness2015s;
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

	public String getDz() {
		return this.dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	public String getYzbm() {
		return this.yzbm;
	}

	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}

	public String getDq() {
		return this.dq;
	}

	public void setDq(String dq) {
		this.dq = dq;
	}

	public String getJb() {
		return this.jb;
	}

	public void setJb(String jb) {
		this.jb = jb;
	}

	public String getCws() {
		return this.cws;
	}

	public void setCws(String cws) {
		this.cws = cws;
	}

	public String getFyljg() {
		return this.fyljg;
	}

	public void setFyljg(String fyljg) {
		this.fyljg = fyljg;
	}

	public String getDh() {
		return this.dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	public String getYjkdh() {
		return this.yjkdh;
	}

	public void setYjkdh(String yjkdh) {
		this.yjkdh = yjkdh;
	}

	public String getLb() {
		return this.lb;
	}

	public void setLb(String lb) {
		this.lb = lb;
	}

	public String getYpsr() {
		return this.ypsr;
	}

	public void setYpsr(String ypsr) {
		this.ypsr = ypsr;
	}

	public String getYwsr() {
		return this.ywsr;
	}

	public void setYwsr(String ywsr) {
		this.ywsr = ywsr;
	}

	public String getCz() {
		return this.cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
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

	public Set getYybusiness2014s() {
		return this.yybusiness2014s;
	}

	public void setYybusiness2014s(Set yybusiness2014s) {
		this.yybusiness2014s = yybusiness2014s;
	}

	public Set getYycgds() {
		return this.yycgds;
	}

	public void setYycgds(Set yycgds) {
		this.yycgds = yycgds;
	}

	public Set getYybusinesses() {
		return this.yybusinesses;
	}

	public void setYybusinesses(Set yybusinesses) {
		this.yybusinesses = yybusinesses;
	}

	public Set getYybusiness2015s() {
		return this.yybusiness2015s;
	}

	public void setYybusiness2015s(Set yybusiness2015s) {
		this.yybusiness2015s = yybusiness2015s;
	}

}