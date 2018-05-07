package com.hibernate.pojo;

/**
 * FileSummaryByEventName entity. @author MyEclipse Persistence Tools
 */

public class FileSummaryByEventName implements java.io.Serializable {

	// Fields

	private FileSummaryByEventNameId id;

	// Constructors

	/** default constructor */
	public FileSummaryByEventName() {
	}

	/** full constructor */
	public FileSummaryByEventName(FileSummaryByEventNameId id) {
		this.id = id;
	}

	// Property accessors

	public FileSummaryByEventNameId getId() {
		return this.id;
	}

	public void setId(FileSummaryByEventNameId id) {
		this.id = id;
	}

}