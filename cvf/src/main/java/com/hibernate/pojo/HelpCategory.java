package com.hibernate.pojo;

/**
 * HelpCategory entity. @author MyEclipse Persistence Tools
 */

public class HelpCategory implements java.io.Serializable {

	// Fields

	private Short helpCategoryId;
	private String name;
	private Short parentCategoryId;
	private String url;

	// Constructors

	/** default constructor */
	public HelpCategory() {
	}

	/** minimal constructor */
	public HelpCategory(Short helpCategoryId, String name, String url) {
		this.helpCategoryId = helpCategoryId;
		this.name = name;
		this.url = url;
	}

	/** full constructor */
	public HelpCategory(Short helpCategoryId, String name,
			Short parentCategoryId, String url) {
		this.helpCategoryId = helpCategoryId;
		this.name = name;
		this.parentCategoryId = parentCategoryId;
		this.url = url;
	}

	// Property accessors

	public Short getHelpCategoryId() {
		return this.helpCategoryId;
	}

	public void setHelpCategoryId(Short helpCategoryId) {
		this.helpCategoryId = helpCategoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getParentCategoryId() {
		return this.parentCategoryId;
	}

	public void setParentCategoryId(Short parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}