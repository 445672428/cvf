package com.hibernate.pojo;

/**
 * TimeZoneName entity. @author MyEclipse Persistence Tools
 */

public class TimeZoneName implements java.io.Serializable {

	// Fields

	private String name;
	private Integer timeZoneId;

	// Constructors

	/** default constructor */
	public TimeZoneName() {
	}

	/** full constructor */
	public TimeZoneName(String name, Integer timeZoneId) {
		this.name = name;
		this.timeZoneId = timeZoneId;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTimeZoneId() {
		return this.timeZoneId;
	}

	public void setTimeZoneId(Integer timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

}