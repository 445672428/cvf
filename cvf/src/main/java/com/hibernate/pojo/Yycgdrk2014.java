package com.hibernate.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Yycgdrk2014 entity. @author MyEclipse Persistence Tools
 */

public class Yycgdrk2014 implements java.io.Serializable {

	// Fields

	private String id;
	private String yycgdid;
	private String ypxxid;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;
	private BigDecimal rkl;
	private String cgzt;
	private Double rkje;
	private String rkdh;
	private String ypph;
	private Double ypyxq;
	private Timestamp rktime;

	// Constructors

	/** default constructor */
	public Yycgdrk2014() {
	}

	/** minimal constructor */
	public Yycgdrk2014(String id, String yycgdid, String ypxxid,
			BigDecimal rkl, String cgzt, Double rkje, String rkdh, String ypph,
			Double ypyxq, Timestamp rktime) {
		this.id = id;
		this.yycgdid = yycgdid;
		this.ypxxid = ypxxid;
		this.rkl = rkl;
		this.cgzt = cgzt;
		this.rkje = rkje;
		this.rkdh = rkdh;
		this.ypph = ypph;
		this.ypyxq = ypyxq;
		this.rktime = rktime;
	}

	/** full constructor */
	public Yycgdrk2014(String id, String yycgdid, String ypxxid, String vchar1,
			String vchar2, String vchar3, String vchar4, String vchar5,
			BigDecimal rkl, String cgzt, Double rkje, String rkdh, String ypph,
			Double ypyxq, Timestamp rktime) {
		this.id = id;
		this.yycgdid = yycgdid;
		this.ypxxid = ypxxid;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
		this.rkl = rkl;
		this.cgzt = cgzt;
		this.rkje = rkje;
		this.rkdh = rkdh;
		this.ypph = ypph;
		this.ypyxq = ypyxq;
		this.rktime = rktime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public BigDecimal getRkl() {
		return this.rkl;
	}

	public void setRkl(BigDecimal rkl) {
		this.rkl = rkl;
	}

	public String getCgzt() {
		return this.cgzt;
	}

	public void setCgzt(String cgzt) {
		this.cgzt = cgzt;
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

}