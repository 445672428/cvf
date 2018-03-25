package com.hibernate.pojo;

import java.math.BigDecimal;

/**
 * Yycgdmx entity. @author MyEclipse Persistence Tools
 */

public class Yycgdmx implements java.io.Serializable {

	// Fields

	private String id;
	private Ypxx ypxx;
	private Usergys usergys;
	private String yycgdid;
	private Double zbjg;
	private Double jyjg;
	private BigDecimal cgl;
	private Double cgje;
	private String cgzt;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;

	// Constructors

	/** default constructor */
	public Yycgdmx() {
	}

	/** minimal constructor */
	public Yycgdmx(String id, Ypxx ypxx, Usergys usergys, String yycgdid) {
		this.id = id;
		this.ypxx = ypxx;
		this.usergys = usergys;
		this.yycgdid = yycgdid;
	}

	/** full constructor */
	public Yycgdmx(String id, Ypxx ypxx, Usergys usergys, String yycgdid,
			Double zbjg, Double jyjg, BigDecimal cgl, Double cgje, String cgzt,
			String vchar1, String vchar2, String vchar3, String vchar4,
			String vchar5) {
		this.id = id;
		this.ypxx = ypxx;
		this.usergys = usergys;
		this.yycgdid = yycgdid;
		this.zbjg = zbjg;
		this.jyjg = jyjg;
		this.cgl = cgl;
		this.cgje = cgje;
		this.cgzt = cgzt;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ypxx getYpxx() {
		return this.ypxx;
	}

	public void setYpxx(Ypxx ypxx) {
		this.ypxx = ypxx;
	}

	public Usergys getUsergys() {
		return this.usergys;
	}

	public void setUsergys(Usergys usergys) {
		this.usergys = usergys;
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

}