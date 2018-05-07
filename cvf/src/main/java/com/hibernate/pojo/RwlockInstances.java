package com.hibernate.pojo;

/**
 * RwlockInstances entity. @author MyEclipse Persistence Tools
 */

public class RwlockInstances implements java.io.Serializable {

	// Fields

	private RwlockInstancesId id;

	// Constructors

	/** default constructor */
	public RwlockInstances() {
	}

	/** full constructor */
	public RwlockInstances(RwlockInstancesId id) {
		this.id = id;
	}

	// Property accessors

	public RwlockInstancesId getId() {
		return this.id;
	}

	public void setId(RwlockInstancesId id) {
		this.id = id;
	}

}