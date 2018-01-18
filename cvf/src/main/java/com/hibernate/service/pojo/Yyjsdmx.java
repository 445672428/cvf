package com.hibernate.service.pojo;

import java.math.BigDecimal;

/**
 * Yyjsdmx entity. @author MyEclipse Persistence Tools
 */

public class Yyjsdmx implements java.io.Serializable {

	// Fields

	private String id;
	private String yyjsdid;
	private String ypxxid;
	private String yycgdid;
	private BigDecimal jsl;
	private Double jsje;
	private String jszt;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;

	// Constructors

	/** default constructor */
	public Yyjsdmx() {
	}

	/** minimal constructor */
	public Yyjsdmx(String id, String yyjsdid, String ypxxid, String yycgdid,
			BigDecimal jsl, Double jsje, String jszt) {
		this.id = id;
		this.yyjsdid = yyjsdid;
		this.ypxxid = ypxxid;
		this.yycgdid = yycgdid;
		this.jsl = jsl;
		this.jsje = jsje;
		this.jszt = jszt;
	}

	/** full constructor */
	public Yyjsdmx(String id, String yyjsdid, String ypxxid, String yycgdid,
			BigDecimal jsl, Double jsje, String jszt, String vchar1,
			String vchar2, String vchar3, String vchar4, String vchar5) {
		this.id = id;
		this.yyjsdid = yyjsdid;
		this.ypxxid = ypxxid;
		this.yycgdid = yycgdid;
		this.jsl = jsl;
		this.jsje = jsje;
		this.jszt = jszt;
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

	public String getYyjsdid() {
		return this.yyjsdid;
	}

	public void setYyjsdid(String yyjsdid) {
		this.yyjsdid = yyjsdid;
	}

	public String getYpxxid() {
		return this.ypxxid;
	}

	public void setYpxxid(String ypxxid) {
		this.ypxxid = ypxxid;
	}

	public String getYycgdid() {
		return this.yycgdid;
	}

	public void setYycgdid(String yycgdid) {
		this.yycgdid = yycgdid;
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