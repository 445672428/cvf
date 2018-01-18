package com.hibernate.service.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Yybusiness2014 entity. @author MyEclipse Persistence Tools
 */

public class Yybusiness2014 implements java.io.Serializable {

	// Fields

	private String id;
	private Useryy useryy;
	private Ypxx ypxx;
	private String yycgdid;
	private Double zbjg;
	private Double jyjg;
	private BigDecimal cgl;
	private Double cgje;
	private String cgzt;
	private BigDecimal rkl;
	private Double rkje;
	private String rkdh;
	private String ypph;
	private Double ypyxq;
	private Timestamp rktime;
	private Timestamp fhtime;
	private String yythdid;
	private String thl;
	private Double thje;
	private String thzt;
	private String thyy;
	private String yyjsdid;
	private BigDecimal jsl;
	private Double jsje;
	private String jszt;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String usergysid;

	// Constructors

	/** default constructor */
	public Yybusiness2014() {
	}

	/** minimal constructor */
	public Yybusiness2014(String id, Useryy useryy, Ypxx ypxx, String yycgdid,
			Double zbjg, Double jyjg, BigDecimal cgl, Double cgje, String cgzt) {
		this.id = id;
		this.useryy = useryy;
		this.ypxx = ypxx;
		this.yycgdid = yycgdid;
		this.zbjg = zbjg;
		this.jyjg = jyjg;
		this.cgl = cgl;
		this.cgje = cgje;
		this.cgzt = cgzt;
	}

	/** full constructor */
	public Yybusiness2014(String id, Useryy useryy, Ypxx ypxx, String yycgdid,
			Double zbjg, Double jyjg, BigDecimal cgl, Double cgje, String cgzt,
			BigDecimal rkl, Double rkje, String rkdh, String ypph,
			Double ypyxq, Timestamp rktime, Timestamp fhtime, String yythdid,
			String thl, Double thje, String thzt, String thyy, String yyjsdid,
			BigDecimal jsl, Double jsje, String jszt, String vchar1,
			String vchar2, String vchar3, String usergysid) {
		this.id = id;
		this.useryy = useryy;
		this.ypxx = ypxx;
		this.yycgdid = yycgdid;
		this.zbjg = zbjg;
		this.jyjg = jyjg;
		this.cgl = cgl;
		this.cgje = cgje;
		this.cgzt = cgzt;
		this.rkl = rkl;
		this.rkje = rkje;
		this.rkdh = rkdh;
		this.ypph = ypph;
		this.ypyxq = ypyxq;
		this.rktime = rktime;
		this.fhtime = fhtime;
		this.yythdid = yythdid;
		this.thl = thl;
		this.thje = thje;
		this.thzt = thzt;
		this.thyy = thyy;
		this.yyjsdid = yyjsdid;
		this.jsl = jsl;
		this.jsje = jsje;
		this.jszt = jszt;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.usergysid = usergysid;
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

	public Ypxx getYpxx() {
		return this.ypxx;
	}

	public void setYpxx(Ypxx ypxx) {
		this.ypxx = ypxx;
	}

	public String getYycgdid() {
		return this.yycgdid;
	}

	public void setYycgdid(String yycgdid) {
		this.yycgdid = yycgdid;
	}

	public Double getZbjg() {
		return this.zbjg;
	}

	public void setZbjg(Double zbjg) {
		this.zbjg = zbjg;
	}

	public Double getJyjg() {
		return this.jyjg;
	}

	public void setJyjg(Double jyjg) {
		this.jyjg = jyjg;
	}

	public BigDecimal getCgl() {
		return this.cgl;
	}

	public void setCgl(BigDecimal cgl) {
		this.cgl = cgl;
	}

	public Double getCgje() {
		return this.cgje;
	}

	public void setCgje(Double cgje) {
		this.cgje = cgje;
	}

	public String getCgzt() {
		return this.cgzt;
	}

	public void setCgzt(String cgzt) {
		this.cgzt = cgzt;
	}

	public BigDecimal getRkl() {
		return this.rkl;
	}

	public void setRkl(BigDecimal rkl) {
		this.rkl = rkl;
	}

	public Double getRkje() {
		return this.rkje;
	}

	public void setRkje(Double rkje) {
		this.rkje = rkje;
	}

	public String getRkdh() {
		return this.rkdh;
	}

	public void setRkdh(String rkdh) {
		this.rkdh = rkdh;
	}

	public String getYpph() {
		return this.ypph;
	}

	public void setYpph(String ypph) {
		this.ypph = ypph;
	}

	public Double getYpyxq() {
		return this.ypyxq;
	}

	public void setYpyxq(Double ypyxq) {
		this.ypyxq = ypyxq;
	}

	public Timestamp getRktime() {
		return this.rktime;
	}

	public void setRktime(Timestamp rktime) {
		this.rktime = rktime;
	}

	public Timestamp getFhtime() {
		return this.fhtime;
	}

	public void setFhtime(Timestamp fhtime) {
		this.fhtime = fhtime;
	}

	public String getYythdid() {
		return this.yythdid;
	}

	public void setYythdid(String yythdid) {
		this.yythdid = yythdid;
	}

	public String getThl() {
		return this.thl;
	}

	public void setThl(String thl) {
		this.thl = thl;
	}

	public Double getThje() {
		return this.thje;
	}

	public void setThje(Double thje) {
		this.thje = thje;
	}

	public String getThzt() {
		return this.thzt;
	}

	public void setThzt(String thzt) {
		this.thzt = thzt;
	}

	public String getThyy() {
		return this.thyy;
	}

	public void setThyy(String thyy) {
		this.thyy = thyy;
	}

	public String getYyjsdid() {
		return this.yyjsdid;
	}

	public void setYyjsdid(String yyjsdid) {
		this.yyjsdid = yyjsdid;
	}

	public BigDecimal getJsl() {
		return this.jsl;
	}

	public void setJsl(BigDecimal jsl) {
		this.jsl = jsl;
	}

	public Double getJsje() {
		return this.jsje;
	}

	public void setJsje(Double jsje) {
		this.jsje = jsje;
	}

	public String getJszt() {
		return this.jszt;
	}

	public void setJszt(String jszt) {
		this.jszt = jszt;
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

	public String getUsergysid() {
		return this.usergysid;
	}

	public void setUsergysid(String usergysid) {
		this.usergysid = usergysid;
	}

}