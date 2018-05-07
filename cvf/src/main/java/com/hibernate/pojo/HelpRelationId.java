package com.hibernate.pojo;

/**
 * HelpRelationId entity. @author MyEclipse Persistence Tools
 */

public class HelpRelationId implements java.io.Serializable {

	// Fields

	private Integer helpKeywordId;
	private Integer helpTopicId;

	// Constructors

	/** default constructor */
	public HelpRelationId() {
	}

	/** full constructor */
	public HelpRelationId(Integer helpKeywordId, Integer helpTopicId) {
		this.helpKeywordId = helpKeywordId;
		this.helpTopicId = helpTopicId;
	}

	// Property accessors

	public Integer getHelpKeywordId() {
		return this.helpKeywordId;
	}

	public void setHelpKeywordId(Integer helpKeywordId) {
		this.helpKeywordId = helpKeywordId;
	}

	public Integer getHelpTopicId() {
		return this.helpTopicId;
	}

	public void setHelpTopicId(Integer helpTopicId) {
		this.helpTopicId = helpTopicId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof HelpRelationId))
			return false;
		HelpRelationId castOther = (HelpRelationId) other;

		return ((this.getHelpKeywordId() == castOther.getHelpKeywordId()) || (this
				.getHelpKeywordId() != null
				&& castOther.getHelpKeywordId() != null && this
				.getHelpKeywordId().equals(castOther.getHelpKeywordId())))
				&& ((this.getHelpTopicId() == castOther.getHelpTopicId()) || (this
						.getHelpTopicId() != null
						&& castOther.getHelpTopicId() != null && this
						.getHelpTopicId().equals(castOther.getHelpTopicId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getHelpKeywordId() == null ? 0 : this.getHelpKeywordId()
						.hashCode());
		result = 37
				* result
				+ (getHelpTopicId() == null ? 0 : this.getHelpTopicId()
						.hashCode());
		return result;
	}

}