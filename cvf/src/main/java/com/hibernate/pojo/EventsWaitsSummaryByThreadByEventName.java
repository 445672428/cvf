package com.hibernate.pojo;

/**
 * EventsWaitsSummaryByThreadByEventName entity. @author MyEclipse Persistence
 * Tools
 */

public class EventsWaitsSummaryByThreadByEventName implements
		java.io.Serializable {

	// Fields

	private EventsWaitsSummaryByThreadByEventNameId id;

	// Constructors

	/** default constructor */
	public EventsWaitsSummaryByThreadByEventName() {
	}

	/** full constructor */
	public EventsWaitsSummaryByThreadByEventName(
			EventsWaitsSummaryByThreadByEventNameId id) {
		this.id = id;
	}

	// Property accessors

	public EventsWaitsSummaryByThreadByEventNameId getId() {
		return this.id;
	}

	public void setId(EventsWaitsSummaryByThreadByEventNameId id) {
		this.id = id;
	}

}