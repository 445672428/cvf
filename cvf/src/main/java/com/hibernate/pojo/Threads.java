package com.hibernate.pojo;

/**
 * Threads entity. @author MyEclipse Persistence Tools
 */

public class Threads implements java.io.Serializable {

	// Fields

	private ThreadsId id;

	// Constructors

	/** default constructor */
	public Threads() {
	}

	/** full constructor */
	public Threads(ThreadsId id) {
		this.id = id;
	}

	// Property accessors

	public ThreadsId getId() {
		return this.id;
	}

	public void setId(ThreadsId id) {
		this.id = id;
	}

}