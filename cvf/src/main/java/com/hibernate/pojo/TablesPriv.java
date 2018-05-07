package com.hibernate.pojo;

import java.sql.Timestamp;

/**
 * TablesPriv entity. @author MyEclipse Persistence Tools
 */

public class TablesPriv implements java.io.Serializable {

	// Fields

	private TablesPrivId id;
	private String grantor;
	private Timestamp timestamp;
	private String tablePriv;
	private String columnPriv;

	// Constructors

	/** default constructor */
	public TablesPriv() {
	}

	/** full constructor */
	public TablesPriv(TablesPrivId id, String grantor, Timestamp timestamp,
			String tablePriv, String columnPriv) {
		this.id = id;
		this.grantor = grantor;
		this.timestamp = timestamp;
		this.tablePriv = tablePriv;
		this.columnPriv = columnPriv;
	}

	// Property accessors

	public TablesPrivId getId() {
		return this.id;
	}

	public void setId(TablesPrivId id) {
		this.id = id;
	}

	public String getGrantor() {
		return this.grantor;
	}

	public void setGrantor(String grantor) {
		this.grantor = grantor;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getTablePriv() {
		return this.tablePriv;
	}

	public void setTablePriv(String tablePriv) {
		this.tablePriv = tablePriv;
	}

	public String getColumnPriv() {
		return this.columnPriv;
	}

	public void setColumnPriv(String columnPriv) {
		this.columnPriv = columnPriv;
	}

}