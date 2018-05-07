package com.hibernate.pojo;

/**
 * SetupConsumers entity. @author MyEclipse Persistence Tools
 */

public class SetupConsumers implements java.io.Serializable {

	// Fields

	private SetupConsumersId id;

	// Constructors

	/** default constructor */
	public SetupConsumers() {
	}

	/** full constructor */
	public SetupConsumers(SetupConsumersId id) {
		this.id = id;
	}

	// Property accessors

	public SetupConsumersId getId() {
		return this.id;
	}

	public void setId(SetupConsumersId id) {
		this.id = id;
	}

}