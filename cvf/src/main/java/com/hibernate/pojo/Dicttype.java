package com.hibernate.pojo;

import java.math.BigDecimal;

/**
 * Dicttype entity. @author MyEclipse Persistence Tools
 */

public class Dicttype implements java.io.Serializable {

	// Fields

	private String typecode;
	private String typename;
	private String remark;
	private BigDecimal typesort;
	private String codelength;

	// Constructors

	/** default constructor */
	public Dicttype() {
	}

	/** minimal constructor */
	public Dicttype(String typecode, String typename) {
		this.typecode = typecode;
		this.typename = typename;
	}

	/** full constructor */
	public Dicttype(String typecode, String typename, String remark,
			BigDecimal typesort, String codelength) {
		this.typecode = typecode;
		this.typename = typename;
		this.remark = remark;
		this.typesort = typesort;
		this.codelength = codelength;
	}

	// Property accessors

	public String getTypecode() {
		return this.typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getTypesort() {
		return this.typesort;
	}

	public void setTypesort(BigDecimal typesort) {
		this.typesort = typesort;
	}

	public String getCodelength() {
		return this.codelength;
	}

	public void setCodelength(String codelength) {
		this.codelength = codelength;
	}

}