package com.hibernate.pojo;

/**
 * FileSummaryByInstance entity. @author MyEclipse Persistence Tools
 */

public class FileSummaryByInstance implements java.io.Serializable {

	// Fields

	private FileSummaryByInstanceId id;

	// Constructors

	/** default constructor */
	public FileSummaryByInstance() {
	}

	/** full constructor */
	public FileSummaryByInstance(FileSummaryByInstanceId id) {
		this.id = id;
	}

	// Property accessors

	public FileSummaryByInstanceId getId() {
		return this.id;
	}

	public void setId(FileSummaryByInstanceId id) {
		this.id = id;
	}

}