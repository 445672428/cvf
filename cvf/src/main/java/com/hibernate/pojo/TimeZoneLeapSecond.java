package com.hibernate.pojo;

/**
 * TimeZoneLeapSecond entity. @author MyEclipse Persistence Tools
 */

public class TimeZoneLeapSecond implements java.io.Serializable {

	// Fields

	private Long transitionTime;
	private Integer correction;

	// Constructors

	/** default constructor */
	public TimeZoneLeapSecond() {
	}

	/** full constructor */
	public TimeZoneLeapSecond(Long transitionTime, Integer correction) {
		this.transitionTime = transitionTime;
		this.correction = correction;
	}

	// Property accessors

	public Long getTransitionTime() {
		return this.transitionTime;
	}

	public void setTransitionTime(Long transitionTime) {
		this.transitionTime = transitionTime;
	}

	public Integer getCorrection() {
		return this.correction;
	}

	public void setCorrection(Integer correction) {
		this.correction = correction;
	}

}