package com.hibernate.pojo;

/**
 * TimeZoneTransition entity. @author MyEclipse Persistence Tools
 */

public class TimeZoneTransition implements java.io.Serializable {

	// Fields

	private TimeZoneTransitionId id;
	private Integer transitionTypeId;

	// Constructors

	/** default constructor */
	public TimeZoneTransition() {
	}

	/** full constructor */
	public TimeZoneTransition(TimeZoneTransitionId id, Integer transitionTypeId) {
		this.id = id;
		this.transitionTypeId = transitionTypeId;
	}

	// Property accessors

	public TimeZoneTransitionId getId() {
		return this.id;
	}

	public void setId(TimeZoneTransitionId id) {
		this.id = id;
	}

	public Integer getTransitionTypeId() {
		return this.transitionTypeId;
	}

	public void setTransitionTypeId(Integer transitionTypeId) {
		this.transitionTypeId = transitionTypeId;
	}

}