package com.hibernate.service.pojo;

/**
 * Userjd entity. @author MyEclipse Persistence Tools
 */

public class Userjd implements java.io.Serializable {

	// Fields

	private String id;
	private String mc;
	private String dz;
	private String yzbm;
	private String xlr;
	private String dh;
	private String cz;
	private String dzyx;
	private String wz;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String dq;

	// Constructors

	/** default constructor */
	public Userjd() {
	}

	/** minimal constructor */
	public Userjd(String id, String mc) {
		this.id = id;
		this.mc = mc;
	}

	/** full constructor */
	public Userjd(String id, String mc, String dz, String yzbm, String xlr,
			String dh, String cz, String dzyx, String wz, String vchar1,
			String vchar2, String vchar3, String dq) {
		this.id = id;
		this.mc = mc;
		this.dz = dz;
		this.yzbm = yzbm;
		this.xlr = xlr;
		this.dh = dh;
		this.cz = cz;
		this.dzyx = dzyx;
		this.wz = wz;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.dq = dq;
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

	public String getXlr() {
		return this.xlr;
	}

	public void setXlr(String xlr) {
		this.xlr = xlr;
	}

	public String getDh() {
		return this.dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	public String getCz() {
		return this.cz;
	}

	public void setCz(String cz) {
		this.cz = cz;
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

	public String getDq() {
		return this.dq;
	}

	public void setDq(String dq) {
		this.dq = dq;
	}

}