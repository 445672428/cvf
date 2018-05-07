package com.hibernate.pojo;

/**
 * TimeZoneTransitionTypeId entity. @author MyEclipse Persistence Tools
 */

public class TimeZoneTransitionTypeId implements java.io.Serializable {

	// Fields

	private Integer timeZoneId;
	private Integer transitionTypeId;

	// Constructors

	/** default constructor */
	public TimeZoneTransitionTypeId() {
	}

	/** full constructor */
	public TimeZoneTransitionTypeId(Integer timeZoneId, Integer transitionTypeId) {
		this.timeZoneId = timeZoneId;
		this.transitionTypeId = transitionTypeId;
	}

	// Property accessors

	public Integer getTimeZoneId() {
		return this.timeZoneId;
	}

	public void setTimeZoneId(Integer timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public Integer getTransitionTypeId() {
		return this.transitionTypeId;
	}

	public void setTransitionTypeId(Integer transitionTypeId) {
		this.transitionTypeId = transitionTypeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TimeZoneTransitionTypeId))
			return false;
		TimeZoneTransitionTypeId castOther = (TimeZoneTransitionTypeId) other;

		return ((this.getTimeZoneId() == castOther.getTimeZoneId()) || (this
				.getTimeZoneId() != null && castOther.getTimeZoneId() != null && this
				.getTimeZoneId().equals(castOther.getTimeZoneId())))
				&& ((this.getTransitionTypeId() == castOther
						.getTransitionTypeId()) || (this.getTransitionTypeId() != null
						&& castOther.getTransitionTypeId() != null && this
						.getTransitionTypeId().equals(
								castOther.getTransitionTypeId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getTimeZoneId() == null ? 0 : this.getTimeZoneId()
						.hashCode());
		result = 37
				* result
				+ (getTransitionTypeId() == null ? 0 : this
						.getTransitionTypeId().hashCode());
		return result;
	}

}