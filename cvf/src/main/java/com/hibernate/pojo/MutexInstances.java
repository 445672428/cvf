package com.hibernate.pojo;

/**
 * MutexInstances entity. @author MyEclipse Persistence Tools
 */

public class MutexInstances implements java.io.Serializable {

	// Fields

	private MutexInstancesId id;

	// Constructors

	/** default constructor */
	public MutexInstances() {
	}

	/** full constructor */
	public MutexInstances(MutexInstancesId id) {
		this.id = id;
	}

	// Property accessors

	public MutexInstancesId getId() {
		return this.id;
	}

	public void setId(MutexInstancesId id) {
		this.id = id;
	}

}