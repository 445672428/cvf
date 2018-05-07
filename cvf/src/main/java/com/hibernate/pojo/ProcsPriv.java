package com.hibernate.pojo;

import java.sql.Timestamp;

/**
 * ProcsPriv entity. @author MyEclipse Persistence Tools
 */

public class ProcsPriv implements java.io.Serializable {

	// Fields

	private ProcsPrivId id;
	private String grantor;
	private String procPriv;
	private Timestamp timestamp;

	// Constructors

	/** default constructor */
	public ProcsPriv() {
	}

	/** full constructor */
	public ProcsPriv(ProcsPrivId id, String grantor, String procPriv,
			Timestamp timestamp) {
		this.id = id;
		this.grantor = grantor;
		this.procPriv = procPriv;
		this.timestamp = timestamp;
	}

	// Property accessors

	public ProcsPrivId getId() {
		return this.id;
	}

	public void setId(ProcsPrivId id) {
		this.id = id;
	}

	public String getGrantor() {
		return this.grantor;
	}

	public void setGrantor(String grantor) {
		this.grantor = grantor;
	}

	public String getProcPriv() {
		return this.procPriv;
	}

	public void setProcPriv(String procPriv) {
		this.procPriv = procPriv;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}