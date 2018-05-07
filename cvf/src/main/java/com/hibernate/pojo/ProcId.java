package com.hibernate.pojo;

/**
 * ProcId entity. @author MyEclipse Persistence Tools
 */

public class ProcId implements java.io.Serializable {

	// Fields

	private String db;
	private String name;
	private String type;

	// Constructors

	/** default constructor */
	public ProcId() {
	}

	/** full constructor */
	public ProcId(String db, String name, String type) {
		this.db = db;
		this.name = name;
		this.type = type;
	}

	// Property accessors

	public String getDb() {
		return this.db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProcId))
			return false;
		ProcId castOther = (ProcId) other;

		return ((this.getDb() == castOther.getDb()) || (this.getDb() != null
				&& castOther.getDb() != null && this.getDb().equals(
				castOther.getDb())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null
						&& castOther.getType() != null && this.getType()
						.equals(castOther.getType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDb() == null ? 0 : this.getDb().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		return result;
	}

}