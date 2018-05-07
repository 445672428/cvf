package com.hibernate.pojo;

/**
 * EventsWaitsHistory entity. @author MyEclipse Persistence Tools
 */

public class EventsWaitsHistory implements java.io.Serializable {

	// Fields

	private EventsWaitsHistoryId id;

	// Constructors

	/** default constructor */
	public EventsWaitsHistory() {
	}

	/** full constructor */
	public EventsWaitsHistory(EventsWaitsHistoryId id) {
		this.id = id;
	}

	// Property accessors

	public EventsWaitsHistoryId getId() {
		return this.id;
	}

	public void setId(EventsWaitsHistoryId id) {
		this.id = id;
	}

}