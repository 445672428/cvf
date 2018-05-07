package com.hibernate.pojo;

/**
 * RwlockInstancesId entity. @author MyEclipse Persistence Tools
 */

public class RwlockInstancesId implements java.io.Serializable {

	// Fields

	private String name;
	private Long objectInstanceBegin;
	private Integer writeLockedByThreadId;
	private Integer readLockedByCount;

	// Constructors

	/** default constructor */
	public RwlockInstancesId() {
	}

	/** minimal constructor */
	public RwlockInstancesId(String name, Long objectInstanceBegin,
			Integer readLockedByCount) {
		this.name = name;
		this.objectInstanceBegin = objectInstanceBegin;
		this.readLockedByCount = readLockedByCount;
	}

	/** full constructor */
	public RwlockInstancesId(String name, Long objectInstanceBegin,
			Integer writeLockedByThreadId, Integer readLockedByCount) {
		this.name = name;
		this.objectInstanceBegin = objectInstanceBegin;
		this.writeLockedByThreadId = writeLockedByThreadId;
		this.readLockedByCount = readLockedByCount;
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

	public Integer getWriteLockedByThreadId() {
		return this.writeLockedByThreadId;
	}

	public void setWriteLockedByThreadId(Integer writeLockedByThreadId) {
		this.writeLockedByThreadId = writeLockedByThreadId;
	}

	public Integer getReadLockedByCount() {
		return this.readLockedByCount;
	}

	public void setReadLockedByCount(Integer readLockedByCount) {
		this.readLockedByCount = readLockedByCount;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RwlockInstancesId))
			return false;
		RwlockInstancesId castOther = (RwlockInstancesId) other;

		return ((this.getName() == castOther.getName()) || (this.getName() != null
				&& castOther.getName() != null && this.getName().equals(
				castOther.getName())))
				&& ((this.getObjectInstanceBegin() == castOther
						.getObjectInstanceBegin()) || (this
						.getObjectInstanceBegin() != null
						&& castOther.getObjectInstanceBegin() != null && this
						.getObjectInstanceBegin().equals(
								castOther.getObjectInstanceBegin())))
				&& ((this.getWriteLockedByThreadId() == castOther
						.getWriteLockedByThreadId()) || (this
						.getWriteLockedByThreadId() != null
						&& castOther.getWriteLockedByThreadId() != null && this
						.getWriteLockedByThreadId().equals(
								castOther.getWriteLockedByThreadId())))
				&& ((this.getReadLockedByCount() == castOther
						.getReadLockedByCount()) || (this
						.getReadLockedByCount() != null
						&& castOther.getReadLockedByCount() != null && this
						.getReadLockedByCount().equals(
								castOther.getReadLockedByCount())));
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
				+ (getWriteLockedByThreadId() == null ? 0 : this
						.getWriteLockedByThreadId().hashCode());
		result = 37
				* result
				+ (getReadLockedByCount() == null ? 0 : this
						.getReadLockedByCount().hashCode());
		return result;
	}

}