package com.hibernate.pojo;

/**
 * SetupTimers entity. @author MyEclipse Persistence Tools
 */

public class SetupTimers implements java.io.Serializable {

	// Fields

	private SetupTimersId id;

	// Constructors

	/** default constructor */
	public SetupTimers() {
	}

	/** full constructor */
	public SetupTimers(SetupTimersId id) {
		this.id = id;
	}

	// Property accessors

	public SetupTimersId getId() {
		return this.id;
	}

	public void setId(SetupTimersId id) {
		this.id = id;
	}

}