package com.hibernate.pojo;

/**
 * EventsWaitsSummaryByInstance entity. @author MyEclipse Persistence Tools
 */

public class EventsWaitsSummaryByInstance implements java.io.Serializable {

	// Fields

	private EventsWaitsSummaryByInstanceId id;

	// Constructors

	/** default constructor */
	public EventsWaitsSummaryByInstance() {
	}

	/** full constructor */
	public EventsWaitsSummaryByInstance(EventsWaitsSummaryByInstanceId id) {
		this.id = id;
	}

	// Property accessors

	public EventsWaitsSummaryByInstanceId getId() {
		return this.id;
	}

	public void setId(EventsWaitsSummaryByInstanceId id) {
		this.id = id;
	}

}