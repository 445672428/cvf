package com.hibernate.pojo;

import java.sql.Timestamp;

/**
 * ColumnsPriv entity. @author MyEclipse Persistence Tools
 */

public class ColumnsPriv implements java.io.Serializable {

	// Fields

	private ColumnsPrivId id;
	private Timestamp timestamp;
	private String columnPriv;

	// Constructors

	/** default constructor */
	public ColumnsPriv() {
	}

	/** full constructor */
	public ColumnsPriv(ColumnsPrivId id, Timestamp timestamp, String columnPriv) {
		this.id = id;
		this.timestamp = timestamp;
		this.columnPriv = columnPriv;
	}

	// Property accessors

	public ColumnsPrivId getId() {
		return this.id;
	}

	public void setId(ColumnsPrivId id) {
		this.id = id;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getColumnPriv() {
		return this.columnPriv;
	}

	public void setColumnPriv(String columnPriv) {
		this.columnPriv = columnPriv;
	}

}