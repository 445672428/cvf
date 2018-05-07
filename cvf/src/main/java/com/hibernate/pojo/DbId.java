package com.hibernate.pojo;

/**
 * DbId entity. @author MyEclipse Persistence Tools
 */

public class DbId implements java.io.Serializable {

	// Fields

	private String host;
	private String db;
	private String user;

	// Constructors

	/** default constructor */
	public DbId() {
	}

	/** full constructor */
	public DbId(String host, String db, String user) {
		this.host = host;
		this.db = db;
		this.user = user;
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

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DbId))
			return false;
		DbId castOther = (DbId) other;

		return ((this.getHost() == castOther.getHost()) || (this.getHost() != null
				&& castOther.getHost() != null && this.getHost().equals(
				castOther.getHost())))
				&& ((this.getDb() == castOther.getDb()) || (this.getDb() != null
						&& castOther.getDb() != null && this.getDb().equals(
						castOther.getDb())))
				&& ((this.getUser() == castOther.getUser()) || (this.getUser() != null
						&& castOther.getUser() != null && this.getUser()
						.equals(castOther.getUser())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getHost() == null ? 0 : this.getHost().hashCode());
		result = 37 * result + (getDb() == null ? 0 : this.getDb().hashCode());
		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		return result;
	}

}