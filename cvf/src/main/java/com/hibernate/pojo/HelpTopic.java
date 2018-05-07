package com.hibernate.pojo;

/**
 * HelpTopic entity. @author MyEclipse Persistence Tools
 */

public class HelpTopic implements java.io.Serializable {

	// Fields

	private Integer helpTopicId;
	private String name;
	private Short helpCategoryId;
	private String description;
	private String example;
	private String url;

	// Constructors

	/** default constructor */
	public HelpTopic() {
	}

	/** full constructor */
	public HelpTopic(Integer helpTopicId, String name, Short helpCategoryId,
			String description, String example, String url) {
		this.helpTopicId = helpTopicId;
		this.name = name;
		this.helpCategoryId = helpCategoryId;
		this.description = description;
		this.example = example;
		this.url = url;
	}

	// Property accessors

	public Integer getHelpTopicId() {
		return this.helpTopicId;
	}

	public void setHelpTopicId(Integer helpTopicId) {
		this.helpTopicId = helpTopicId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getHelpCategoryId() {
		return this.helpCategoryId;
	}

	public void setHelpCategoryId(Short helpCategoryId) {
		this.helpCategoryId = helpCategoryId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExample() {
		return this.example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}