package com.hibernate.pojo;

/**
 * TimeZone entity. @author MyEclipse Persistence Tools
 */

public class TimeZone implements java.io.Serializable {

	// Fields

	private Integer timeZoneId;
	private String useLeapSeconds;

	// Constructors

	/** default constructor */
	public TimeZone() {
	}

	/** full constructor */
	public TimeZone(String useLeapSeconds) {
		this.useLeapSeconds = useLeapSeconds;
	}

	// Property accessors

	public Integer getTimeZoneId() {
		return this.timeZoneId;
	}

	public void setTimeZoneId(Integer timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public String getUseLeapSeconds() {
		return this.useLeapSeconds;
	}

	public void setUseLeapSeconds(String useLeapSeconds) {
		this.useLeapSeconds = useLeapSeconds;
	}

}