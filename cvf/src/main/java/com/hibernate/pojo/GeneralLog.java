package com.hibernate.pojo;

/**
 * GeneralLog entity. @author MyEclipse Persistence Tools
 */

public class GeneralLog implements java.io.Serializable {

	// Fields

	private GeneralLogId id;

	// Constructors

	/** default constructor */
	public GeneralLog() {
	}

	/** full constructor */
	public GeneralLog(GeneralLogId id) {
		this.id = id;
	}

	// Property accessors

	public GeneralLogId getId() {
		return this.id;
	}

	public void setId(GeneralLogId id) {
		this.id = id;
	}

}