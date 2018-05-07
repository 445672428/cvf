package com.hibernate.pojo;

import java.sql.Timestamp;

/**
 * ProxiesPriv entity. @author MyEclipse Persistence Tools
 */

public class ProxiesPriv implements java.io.Serializable {

	// Fields

	private ProxiesPrivId id;
	private Boolean withGrant;
	private String grantor;
	private Timestamp timestamp;

	// Constructors

	/** default constructor */
	public ProxiesPriv() {
	}

	/** full constructor */
	public ProxiesPriv(ProxiesPrivId id, Boolean withGrant, String grantor,
			Timestamp timestamp) {
		this.id = id;
		this.withGrant = withGrant;
		this.grantor = grantor;
		this.timestamp = timestamp;
	}

	// Property accessors

	public ProxiesPrivId getId() {
		return this.id;
	}

	public void setId(ProxiesPrivId id) {
		this.id = id;
	}

	public Boolean getWithGrant() {
		return this.withGrant;
	}

	public void setWithGrant(Boolean withGrant) {
		this.withGrant = withGrant;
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

}