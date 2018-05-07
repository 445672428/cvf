package com.hibernate.pojo;

/**
 * FileInstancesId entity. @author MyEclipse Persistence Tools
 */

public class FileInstancesId implements java.io.Serializable {

	// Fields

	private String fileName;
	private String eventName;
	private Integer openCount;

	// Constructors

	/** default constructor */
	public FileInstancesId() {
	}

	/** full constructor */
	public FileInstancesId(String fileName, String eventName, Integer openCount) {
		this.fileName = fileName;
		this.eventName = eventName;
		this.openCount = openCount;
	}

	// Property accessors

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Integer getOpenCount() {
		return this.openCount;
	}

	public void setOpenCount(Integer openCount) {
		this.openCount = openCount;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FileInstancesId))
			return false;
		FileInstancesId castOther = (FileInstancesId) other;

		return ((this.getFileName() == castOther.getFileName()) || (this
				.getFileName() != null && castOther.getFileName() != null && this
				.getFileName().equals(castOther.getFileName())))
				&& ((this.getEventName() == castOther.getEventName()) || (this
						.getEventName() != null
						&& castOther.getEventName() != null && this
						.getEventName().equals(castOther.getEventName())))
				&& ((this.getOpenCount() == castOther.getOpenCount()) || (this
						.getOpenCount() != null
						&& castOther.getOpenCount() != null && this
						.getOpenCount().equals(castOther.getOpenCount())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFileName() == null ? 0 : this.getFileName().hashCode());
		result = 37 * result
				+ (getEventName() == null ? 0 : this.getEventName().hashCode());
		result = 37 * result
				+ (getOpenCount() == null ? 0 : this.getOpenCount().hashCode());
		return result;
	}

}