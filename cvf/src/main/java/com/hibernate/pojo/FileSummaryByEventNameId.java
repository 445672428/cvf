package com.hibernate.pojo;

/**
 * FileSummaryByEventNameId entity. @author MyEclipse Persistence Tools
 */

public class FileSummaryByEventNameId implements java.io.Serializable {

	// Fields

	private String eventName;
	private Long countRead;
	private Long countWrite;
	private Long sumNumberOfBytesRead;
	private Long sumNumberOfBytesWrite;

	// Constructors

	/** default constructor */
	public FileSummaryByEventNameId() {
	}

	/** full constructor */
	public FileSummaryByEventNameId(String eventName, Long countRead,
			Long countWrite, Long sumNumberOfBytesRead,
			Long sumNumberOfBytesWrite) {
		this.eventName = eventName;
		this.countRead = countRead;
		this.countWrite = countWrite;
		this.sumNumberOfBytesRead = sumNumberOfBytesRead;
		this.sumNumberOfBytesWrite = sumNumberOfBytesWrite;
	}

	// Property accessors

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Long getCountRead() {
		return this.countRead;
	}

	public void setCountRead(Long countRead) {
		this.countRead = countRead;
	}

	public Long getCountWrite() {
		return this.countWrite;
	}

	public void setCountWrite(Long countWrite) {
		this.countWrite = countWrite;
	}

	public Long getSumNumberOfBytesRead() {
		return this.sumNumberOfBytesRead;
	}

	public void setSumNumberOfBytesRead(Long sumNumberOfBytesRead) {
		this.sumNumberOfBytesRead = sumNumberOfBytesRead;
	}

	public Long getSumNumberOfBytesWrite() {
		return this.sumNumberOfBytesWrite;
	}

	public void setSumNumberOfBytesWrite(Long sumNumberOfBytesWrite) {
		this.sumNumberOfBytesWrite = sumNumberOfBytesWrite;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FileSummaryByEventNameId))
			return false;
		FileSummaryByEventNameId castOther = (FileSummaryByEventNameId) other;

		return ((this.getEventName() == castOther.getEventName()) || (this
				.getEventName() != null && castOther.getEventName() != null && this
				.getEventName().equals(castOther.getEventName())))
				&& ((this.getCountRead() == castOther.getCountRead()) || (this
						.getCountRead() != null
						&& castOther.getCountRead() != null && this
						.getCountRead().equals(castOther.getCountRead())))
				&& ((this.getCountWrite() == castOther.getCountWrite()) || (this
						.getCountWrite() != null
						&& castOther.getCountWrite() != null && this
						.getCountWrite().equals(castOther.getCountWrite())))
				&& ((this.getSumNumberOfBytesRead() == castOther
						.getSumNumberOfBytesRead()) || (this
						.getSumNumberOfBytesRead() != null
						&& castOther.getSumNumberOfBytesRead() != null && this
						.getSumNumberOfBytesRead().equals(
								castOther.getSumNumberOfBytesRead())))
				&& ((this.getSumNumberOfBytesWrite() == castOther
						.getSumNumberOfBytesWrite()) || (this
						.getSumNumberOfBytesWrite() != null
						&& castOther.getSumNumberOfBytesWrite() != null && this
						.getSumNumberOfBytesWrite().equals(
								castOther.getSumNumberOfBytesWrite())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEventName() == null ? 0 : this.getEventName().hashCode());
		result = 37 * result
				+ (getCountRead() == null ? 0 : this.getCountRead().hashCode());
		result = 37
				* result
				+ (getCountWrite() == null ? 0 : this.getCountWrite()
						.hashCode());
		result = 37
				* result
				+ (getSumNumberOfBytesRead() == null ? 0 : this
						.getSumNumberOfBytesRead().hashCode());
		result = 37
				* result
				+ (getSumNumberOfBytesWrite() == null ? 0 : this
						.getSumNumberOfBytesWrite().hashCode());
		return result;
	}

}