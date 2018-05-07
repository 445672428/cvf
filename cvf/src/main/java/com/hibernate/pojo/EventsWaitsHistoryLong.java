package com.hibernate.pojo;

/**
 * EventsWaitsHistoryLong entity. @author MyEclipse Persistence Tools
 */

public class EventsWaitsHistoryLong implements java.io.Serializable {

	// Fields

	private EventsWaitsHistoryLongId id;

	// Constructors

	/** default constructor */
	public EventsWaitsHistoryLong() {
	}

	/** full constructor */
	public EventsWaitsHistoryLong(EventsWaitsHistoryLongId id) {
		this.id = id;
	}

	// Property accessors

	public EventsWaitsHistoryLongId getId() {
		return this.id;
	}

	public void setId(EventsWaitsHistoryLongId id) {
		this.id = id;
	}

}