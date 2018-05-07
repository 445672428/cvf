package com.hibernate.pojo;

/**
 * HelpKeyword entity. @author MyEclipse Persistence Tools
 */

public class HelpKeyword implements java.io.Serializable {

	// Fields

	private Integer helpKeywordId;
	private String name;

	// Constructors

	/** default constructor */
	public HelpKeyword() {
	}

	/** full constructor */
	public HelpKeyword(Integer helpKeywordId, String name) {
		this.helpKeywordId = helpKeywordId;
		this.name = name;
	}

	// Property accessors

	public Integer getHelpKeywordId() {
		return this.helpKeywordId;
	}

	public void setHelpKeywordId(Integer helpKeywordId) {
		this.helpKeywordId = helpKeywordId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}