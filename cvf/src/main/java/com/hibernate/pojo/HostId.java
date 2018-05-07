package com.hibernate.pojo;

/**
 * HostId entity. @author MyEclipse Persistence Tools
 */

public class HostId implements java.io.Serializable {

	// Fields

	private String host;
	private String db;

	// Constructors

	/** default constructor */
	public HostId() {
	}

	/** full constructor */
	public HostId(String host, String db) {
		this.host = host;
		this.db = db;
	}

	// Property accessors

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDb() {
		return this.db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof HostId))
			return false;
		HostId castOther = (HostId) other;

		return ((this.getHost() == castOther.getHost()) || (this.getHost() != null
				&& castOther.getHost() != null && this.getHost().equals(
				castOther.getHost())))
				&& ((this.getDb() == castOther.getDb()) || (this.getDb() != null
						&& castOther.getDb() != null && this.getDb().equals(
						castOther.getDb())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getHost() == null ? 0 : this.getHost().hashCode());
		result = 37 * result + (getDb() == null ? 0 : this.getDb().hashCode());
		return result;
	}

}