package com.hibernate.pojo;

/**
 * PerformanceTimers entity. @author MyEclipse Persistence Tools
 */

public class PerformanceTimers implements java.io.Serializable {

	// Fields

	private PerformanceTimersId id;

	// Constructors

	/** default constructor */
	public PerformanceTimers() {
	}

	/** full constructor */
	public PerformanceTimers(PerformanceTimersId id) {
		this.id = id;
	}

	// Property accessors

	public PerformanceTimersId getId() {
		return this.id;
	}

	public void setId(PerformanceTimersId id) {
		this.id = id;
	}

}