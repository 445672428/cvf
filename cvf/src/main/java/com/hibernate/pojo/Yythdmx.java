package com.hibernate.pojo;

import java.math.BigDecimal;

/**
 * Yythdmx entity. @author MyEclipse Persistence Tools
 */

public class Yythdmx implements java.io.Serializable {

	// Fields

	private String id;
	private String yythdid;
	private String yycgdid;
	private String ypxxid;
	private BigDecimal thl;
	private Double thje;
	private String thzt;
	private String thyy;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;

	// Constructors

	/** default constructor */
	public Yythdmx() {
	}

	/** minimal constructor */
	public Yythdmx(String id, String yythdid, String yycgdid, String ypxxid,
			BigDecimal thl, Double thje, String thzt) {
		this.id = id;
		this.yythdid = yythdid;
		this.yycgdid = yycgdid;
		this.ypxxid = ypxxid;
		this.thl = thl;
		this.thje = thje;
		this.thzt = thzt;
	}

	/** full constructor */
	public Yythdmx(String id, String yythdid, String yycgdid, String ypxxid,
			BigDecimal thl, Double thje, String thzt, String thyy,
			String vchar1, String vchar2, String vchar3, String vchar4,
			String vchar5) {
		this.id = id;
		this.yythdid = yythdid;
		this.yycgdid = yycgdid;
		this.ypxxid = ypxxid;
		this.thl = thl;
		this.thje = thje;
		this.thzt = thzt;
		this.thyy = thyy;
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

	public String getYythdid() {
		return this.yythdid;
	}

	public void setYythdid(String yythdid) {
		this.yythdid = yythdid;
	}

	public String getYycgdid() {
		return this.yycgdid;
	}

	public void setYycgdid(String yycgdid) {
		this.yycgdid = yycgdid;
	}

	public String getYpxxid() {
		return this.ypxxid;
	}

	public void setYpxxid(String ypxxid) {
		this.ypxxid = ypxxid;
	}

	public BigDecimal getThl() {
		return this.thl;
	}

	public void setThl(BigDecimal thl) {
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