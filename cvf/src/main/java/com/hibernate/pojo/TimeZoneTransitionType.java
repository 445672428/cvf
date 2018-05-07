package com.hibernate.pojo;

/**
 * TimeZoneTransitionType entity. @author MyEclipse Persistence Tools
 */

public class TimeZoneTransitionType implements java.io.Serializable {

	// Fields

	private TimeZoneTransitionTypeId id;
	private Integer offset;
	private Short isDst;
	private String abbreviation;

	// Constructors

	/** default constructor */
	public TimeZoneTransitionType() {
	}

	/** full constructor */
	public TimeZoneTransitionType(TimeZoneTransitionTypeId id, Integer offset,
			Short isDst, String abbreviation) {
		this.id = id;
		this.offset = offset;
		this.isDst = isDst;
		this.abbreviation = abbreviation;
	}

	// Property accessors

	public TimeZoneTransitionTypeId getId() {
		return this.id;
	}

	public void setId(TimeZoneTransitionTypeId id) {
		this.id = id;
	}

	public Integer getOffset() {
		return this.offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Short getIsDst() {
		return this.isDst;
	}

	public void setIsDst(Short isDst) {
		this.isDst = isDst;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

}