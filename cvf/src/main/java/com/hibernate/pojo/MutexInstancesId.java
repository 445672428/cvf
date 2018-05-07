package com.hibernate.pojo;

/**
 * MutexInstancesId entity. @author MyEclipse Persistence Tools
 */

public class MutexInstancesId implements java.io.Serializable {

	// Fields

	private String name;
	private Long objectInstanceBegin;
	private Integer lockedByThreadId;

	// Constructors

	/** default constructor */
	public MutexInstancesId() {
	}

	/** minimal constructor */
	public MutexInstancesId(String name, Long objectInstanceBegin) {
		this.name = name;
		this.objectInstanceBegin = objectInstanceBegin;
	}

	/** full constructor */
	public MutexInstancesId(String name, Long objectInstanceBegin,
			Integer lockedByThreadId) {
		this.name = name;
		this.objectInstanceBegin = objectInstanceBegin;
		this.lockedByThreadId = lockedByThreadId;
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

	public Integer getLockedByThreadId() {
		return this.lockedByThreadId;
	}

	public void setLockedByThreadId(Integer lockedByThreadId) {
		this.lockedByThreadId = lockedByThreadId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MutexInstancesId))
			return false;
		MutexInstancesId castOther = (MutexInstancesId) other;

		return ((this.getName() == castOther.getName()) || (this.getName() != null
				&& castOther.getName() != null && this.getName().equals(
				castOther.getName())))
				&& ((this.getObjectInstanceBegin() == castOther
						.getObjectInstanceBegin()) || (this
						.getObjectInstanceBegin() != null
						&& castOther.getObjectInstanceBegin() != null && this
						.getObjectInstanceBegin().equals(
								castOther.getObjectInstanceBegin())))
				&& ((this.getLockedByThreadId() == castOther
						.getLockedByThreadId()) || (this.getLockedByThreadId() != null
						&& castOther.getLockedByThreadId() != null && this
						.getLockedByThreadId().equals(
								castOther.getLockedByThreadId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37
				* result
				+ (getObjectInstanceBegin() == null ? 0 : this
						.getObjectInstanceBegin().hashCode());
		result = 37
				* result
				+ (getLockedByThreadId() == null ? 0 : this
						.getLockedByThreadId().hashCode());
		return result;
	}

}