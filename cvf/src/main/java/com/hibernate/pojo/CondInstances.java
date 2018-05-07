package com.hibernate.pojo;

/**
 * CondInstances entity. @author MyEclipse Persistence Tools
 */

public class CondInstances implements java.io.Serializable {

	// Fields

	private CondInstancesId id;

	// Constructors

	/** default constructor */
	public CondInstances() {
	}

	/** full constructor */
	public CondInstances(CondInstancesId id) {
		this.id = id;
	}

	// Property accessors

	public CondInstancesId getId() {
		return this.id;
	}

	public void setId(CondInstancesId id) {
		this.id = id;
	}

}