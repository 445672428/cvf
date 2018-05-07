package com.hibernate.pojo;

/**
 * SetupInstruments entity. @author MyEclipse Persistence Tools
 */

public class SetupInstruments implements java.io.Serializable {

	// Fields

	private SetupInstrumentsId id;

	// Constructors

	/** default constructor */
	public SetupInstruments() {
	}

	/** full constructor */
	public SetupInstruments(SetupInstrumentsId id) {
		this.id = id;
	}

	// Property accessors

	public SetupInstrumentsId getId() {
		return this.id;
	}

	public void setId(SetupInstrumentsId id) {
		this.id = id;
	}

}