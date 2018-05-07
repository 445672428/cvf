package com.hibernate.pojo;

/**
 * TimeZoneTransitionId entity. @author MyEclipse Persistence Tools
 */

public class TimeZoneTransitionId implements java.io.Serializable {

	// Fields

	private Integer timeZoneId;
	private Long transitionTime;

	// Constructors

	/** default constructor */
	public TimeZoneTransitionId() {
	}

	/** full constructor */
	public TimeZoneTransitionId(Integer timeZoneId, Long transitionTime) {
		this.timeZoneId = timeZoneId;
		this.transitionTime = transitionTime;
	}

	// Property accessors

	public Integer getTimeZoneId() {
		return this.timeZoneId;
	}

	public void setTimeZoneId(Integer timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public Long getTransitionTime() {
		return this.transitionTime;
	}

	public void setTransitionTime(Long transitionTime) {
		this.transitionTime = transitionTime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TimeZoneTransitionId))
			return false;
		TimeZoneTransitionId castOther = (TimeZoneTransitionId) other;

		return ((this.getTimeZoneId() == castOther.getTimeZoneId()) || (this
				.getTimeZoneId() != null && castOther.getTimeZoneId() != null && this
				.getTimeZoneId().equals(castOther.getTimeZoneId())))
				&& ((this.getTransitionTime() == castOther.getTransitionTime()) || (this
						.getTransitionTime() != null
						&& castOther.getTransitionTime() != null && this
						.getTransitionTime().equals(
								castOther.getTransitionTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTimeZoneId() == null ? 0 : this.getTimeZoneId()
						.hashCode());
		result = 37
				* result
				+ (getTransitionTime() == null ? 0 : this.getTransitionTime()
						.hashCode());
		return result;
	}

}