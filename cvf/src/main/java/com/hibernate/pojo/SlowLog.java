package com.hibernate.pojo;

/**
 * SlowLog entity. @author MyEclipse Persistence Tools
 */

public class SlowLog implements java.io.Serializable {

	// Fields

	private SlowLogId id;

	// Constructors

	/** default constructor */
	public SlowLog() {
	}

	/** full constructor */
	public SlowLog(SlowLogId id) {
		this.id = id;
	}

	// Property accessors

	public SlowLogId getId() {
		return this.id;
	}

	public void setId(SlowLogId id) {
		this.id = id;
	}

}