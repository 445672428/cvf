package com.hibernate.pojo;

/**
 * HelpRelation entity. @author MyEclipse Persistence Tools
 */

public class HelpRelation implements java.io.Serializable {

	// Fields

	private HelpRelationId id;

	// Constructors

	/** default constructor */
	public HelpRelation() {
	}

	/** full constructor */
	public HelpRelation(HelpRelationId id) {
		this.id = id;
	}

	// Property accessors

	public HelpRelationId getId() {
		return this.id;
	}

	public void setId(HelpRelationId id) {
		this.id = id;
	}

}