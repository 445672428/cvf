package com.hibernate.pojo;

/**
 * TablesPrivId entity. @author MyEclipse Persistence Tools
 */

public class TablesPrivId implements java.io.Serializable {

	// Fields

	private String host;
	private String db;
	private String user;
	private String tableName;

	// Constructors

	/** default constructor */
	public TablesPrivId() {
	}

	/** full constructor */
	public TablesPrivId(String host, String db, String user, String tableName) {
		this.host = host;
		this.db = db;
		this.user = user;
		this.tableName = tableName;
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

	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TablesPrivId))
			return false;
		TablesPrivId castOther = (TablesPrivId) other;

		return ((this.getHost() == castOther.getHost()) || (this.getHost() != null
				&& castOther.getHost() != null && this.getHost().equals(
				castOther.getHost())))
				&& ((this.getDb() == castOther.getDb()) || (this.getDb() != null
						&& castOther.getDb() != null && this.getDb().equals(
						castOther.getDb())))
				&& ((this.getUser() == castOther.getUser()) || (this.getUser() != null
						&& castOther.getUser() != null && this.getUser()
						.equals(castOther.getUser())))
				&& ((this.getTableName() == castOther.getTableName()) || (this
						.getTableName() != null
						&& castOther.getTableName() != null && this
						.getTableName().equals(castOther.getTableName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getHost() == null ? 0 : this.getHost().hashCode());
		result = 37 * result + (getDb() == null ? 0 : this.getDb().hashCode());
		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37 * result
				+ (getTableName() == null ? 0 : this.getTableName().hashCode());
		return result;
	}

}