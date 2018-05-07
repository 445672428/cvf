package com.hibernate.pojo;

/**
 * FileInstances entity. @author MyEclipse Persistence Tools
 */

public class FileInstances implements java.io.Serializable {

	// Fields

	private FileInstancesId id;

	// Constructors

	/** default constructor */
	public FileInstances() {
	}

	/** full constructor */
	public FileInstances(FileInstancesId id) {
		this.id = id;
	}

	// Property accessors

	public FileInstancesId getId() {
		return this.id;
	}

	public void setId(FileInstancesId id) {
		this.id = id;
	}

}