package com.hibernate.service.pojo;

/**
 * YpxxBackup entity. @author MyEclipse Persistence Tools
 */

public class YpxxBackup implements java.io.Serializable {

	// Fields

	private YpxxBackupId id;

	// Constructors

	/** default constructor */
	public YpxxBackup() {
	}

	/** full constructor */
	public YpxxBackup(YpxxBackupId id) {
		this.id = id;
	}

	// Property accessors

	public YpxxBackupId getId() {
		return this.id;
	}

	public void setId(YpxxBackupId id) {
		this.id = id;
	}

}