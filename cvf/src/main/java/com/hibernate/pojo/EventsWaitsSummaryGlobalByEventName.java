package com.hibernate.pojo;

/**
 * EventsWaitsSummaryGlobalByEventName entity. @author MyEclipse Persistence
 * Tools
 */

public class EventsWaitsSummaryGlobalByEventName implements
		java.io.Serializable {

	// Fields

	private EventsWaitsSummaryGlobalByEventNameId id;

	// Constructors

	/** default constructor */
	public EventsWaitsSummaryGlobalByEventName() {
	}

	/** full constructor */
	public EventsWaitsSummaryGlobalByEventName(
			EventsWaitsSummaryGlobalByEventNameId id) {
		this.id = id;
	}

	// Property accessors

	public EventsWaitsSummaryGlobalByEventNameId getId() {
		return this.id;
	}

	public void setId(EventsWaitsSummaryGlobalByEventNameId id) {
		this.id = id;
	}

}