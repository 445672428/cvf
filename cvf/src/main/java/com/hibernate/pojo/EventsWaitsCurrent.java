package com.hibernate.pojo;

/**
 * EventsWaitsCurrent entity. @author MyEclipse Persistence Tools
 */

public class EventsWaitsCurrent implements java.io.Serializable {

	// Fields

	private EventsWaitsCurrentId id;

	// Constructors

	/** default constructor */
	public EventsWaitsCurrent() {
	}

	/** full constructor */
	public EventsWaitsCurrent(EventsWaitsCurrentId id) {
		this.id = id;
	}

	// Property accessors

	public EventsWaitsCurrentId getId() {
		return this.id;
	}

	public void setId(EventsWaitsCurrentId id) {
		this.id = id;
	}

}