package com.hibernate.service.pojo;

/**
 * Sysrolemodule entity. @author MyEclipse Persistence Tools
 */

public class Sysrolemodule implements java.io.Serializable {

	// Fields

	private SysrolemoduleId id;

	// Constructors

	/** default constructor */
	public Sysrolemodule() {
	}

	/** full constructor */
	public Sysrolemodule(SysrolemoduleId id) {
		this.id = id;
	}

	// Property accessors

	public SysrolemoduleId getId() {
		return this.id;
	}

	public void setId(SysrolemoduleId id) {
		this.id = id;
	}

}