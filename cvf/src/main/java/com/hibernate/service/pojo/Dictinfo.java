package com.hibernate.service.pojo;

import java.math.BigDecimal;

/**
 * Dictinfo entity. @author MyEclipse Persistence Tools
 */

public class Dictinfo implements java.io.Serializable {

	// Fields

	private String id;
	private String dictcode;
	private String typecode;
	private String info;
	private String remark;
	private String updatetime;
	private BigDecimal dictsort;
	private String isenable;
	private String valuetype;

	// Constructors

	/** default constructor */
	public Dictinfo() {
	}

	/** minimal constructor */
	public Dictinfo(String id, String typecode, String info, String isenable) {
		this.id = id;
		this.typecode = typecode;
		this.info = info;
		this.isenable = isenable;
	}

	/** full constructor */
	public Dictinfo(String id, String dictcode, String typecode, String info,
			String remark, String updatetime, BigDecimal dictsort,
			String isenable, String valuetype) {
		this.id = id;
		this.dictcode = dictcode;
		this.typecode = typecode;
		this.info = info;
		this.remark = remark;
		this.updatetime = updatetime;
		this.dictsort = dictsort;
		this.isenable = isenable;
		this.valuetype = valuetype;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDictcode() {
		return this.dictcode;
	}

	public void setDictcode(String dictcode) {
		this.dictcode = dictcode;
	}

	public String getTypecode() {
		return this.typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public BigDecimal getDictsort() {
		return this.dictsort;
	}

	public void setDictsort(BigDecimal dictsort) {
		this.dictsort = dictsort;
	}

	public String getIsenable() {
		return this.isenable;
	}

	public void setIsenable(String isenable) {
		this.isenable = isenable;
	}

	public String getValuetype() {
		return this.valuetype;
	}

	public void setValuetype(String valuetype) {
		this.valuetype = valuetype;
	}

}