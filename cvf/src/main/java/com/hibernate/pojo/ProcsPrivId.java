package com.hibernate.pojo;

/**
 * ProcsPrivId entity. @author MyEclipse Persistence Tools
 */

public class ProcsPrivId implements java.io.Serializable {

	// Fields

	private String host;
	private String db;
	private String user;
	private String routineName;
	private String routineType;

	// Constructors

	/** default constructor */
	public ProcsPrivId() {
	}

	/** full constructor */
	public ProcsPrivId(String host, String db, String user, String routineName,
			String routineType) {
		this.host = host;
		this.db = db;
		this.user = user;
		this.routineName = routineName;
		this.routineType = routineType;
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

	public String getRoutineName() {
		return this.routineName;
	}

	public void setRoutineName(String routineName) {
		this.routineName = routineName;
	}

	public String getRoutineType() {
		return this.routineType;
	}

	public void setRoutineType(String routineType) {
		this.routineType = routineType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProcsPrivId))
			return false;
		ProcsPrivId castOther = (ProcsPrivId) other;

		return ((this.getHost() == castOther.getHost()) || (this.getHost() != null
				&& castOther.getHost() != null && this.getHost().equals(
				castOther.getHost())))
				&& ((this.getDb() == castOther.getDb()) || (this.getDb() != null
						&& castOther.getDb() != null && this.getDb().equals(
						castOther.getDb())))
				&& ((this.getUser() == castOther.getUser()) || (this.getUser() != null
						&& castOther.getUser() != null && this.getUser()
						.equals(castOther.getUser())))
				&& ((this.getRoutineName() == castOther.getRoutineName()) || (this
						.getRoutineName() != null
						&& castOther.getRoutineName() != null && this
						.getRoutineName().equals(castOther.getRoutineName())))
				&& ((this.getRoutineType() == castOther.getRoutineType()) || (this
						.getRoutineType() != null
						&& castOther.getRoutineType() != null && this
						.getRoutineType().equals(castOther.getRoutineType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getHost() == null ? 0 : this.getHost().hashCode());
		result = 37 * result + (getDb() == null ? 0 : this.getDb().hashCode());
		result = 37 * result
				+ (getUser() == null ? 0 : this.getUser().hashCode());
		result = 37
				* result
				+ (getRoutineName() == null ? 0 : this.getRoutineName()
						.hashCode());
		result = 37
				* result
				+ (getRoutineType() == null ? 0 : this.getRoutineType()
						.hashCode());
		return result;
	}

}