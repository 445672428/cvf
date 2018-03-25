package com.hibernate.pojo;

/**
 * ErrorTaskBackup entity. @author MyEclipse Persistence Tools
 */

public class ErrorTaskBackup implements java.io.Serializable {

	// Fields

	private ErrorTaskBackupId id;

	// Constructors

	/** default constructor */
	public ErrorTaskBackup() {
	}

	/** full constructor */
	public ErrorTaskBackup(ErrorTaskBackupId id) {
		this.id = id;
	}

	// Property accessors

	public ErrorTaskBackupId getId() {
		return this.id;
	}

	public void setId(ErrorTaskBackupId id) {
		this.id = id;
	}

}