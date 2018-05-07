package com.hibernate.pojo;

/**
 * CondInstancesId entity. @author MyEclipse Persistence Tools
 */

public class CondInstancesId implements java.io.Serializable {

	// Fields

	private String name;
	private Long objectInstanceBegin;

	// Constructors

	/** default constructor */
	public CondInstancesId() {
	}

	/** full constructor */
	public CondInstancesId(String name, Long objectInstanceBegin) {
		this.name = name;
		this.objectInstanceBegin = objectInstanceBegin;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getObjectInstanceBegin() {
		return this.objectInstanceBegin;
	}

	public void setObjectInstanceBegin(Long objectInstanceBegin) {
		this.objectInstanceBegin = objectInstanceBegin;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CondInstancesId))
			return false;
		CondInstancesId castOther = (CondInstancesId) other;

		return ((this.getName() == castOther.getName()) || (this.getName() != null
				&& castOther.getName() != null && this.getName().equals(
				castOther.getName())))
				&& ((this.getObjectInstanceBegin() == castOther
						.getObjectInstanceBegin()) || (this
						.getObjectInstanceBegin() != null
						&& castOther.getObjectInstanceBegin() != null && this
						.getObjectInstanceBegin().equals(
								castOther.getObjectInstanceBegin())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37
				* result
				+ (getObjectInstanceBegin() == null ? 0 : this
						.getObjectInstanceBegin().hashCode());
		return result;
	}

}