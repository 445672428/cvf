package com.hibernate.pojo;

/**
 * EventsWaitsSummaryByThreadByEventNameId entity. @author MyEclipse Persistence
 * Tools
 */

public class EventsWaitsSummaryByThreadByEventNameId implements
		java.io.Serializable {

	// Fields

	private Integer threadId;
	private String eventName;
	private Long countStar;
	private Long sumTimerWait;
	private Long minTimerWait;
	private Long avgTimerWait;
	private Long maxTimerWait;

	// Constructors

	/** default constructor */
	public EventsWaitsSummaryByThreadByEventNameId() {
	}

	/** full constructor */
	public EventsWaitsSummaryByThreadByEventNameId(Integer threadId,
			String eventName, Long countStar, Long sumTimerWait,
			Long minTimerWait, Long avgTimerWait, Long maxTimerWait) {
		this.threadId = threadId;
		this.eventName = eventName;
		this.countStar = countStar;
		this.sumTimerWait = sumTimerWait;
		this.minTimerWait = minTimerWait;
		this.avgTimerWait = avgTimerWait;
		this.maxTimerWait = maxTimerWait;
	}

	// Property accessors

	public Integer getThreadId() {
		return this.threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Long getCountStar() {
		return this.countStar;
	}

	public void setCountStar(Long countStar) {
		this.countStar = countStar;
	}

	public Long getSumTimerWait() {
		return this.sumTimerWait;
	}

	public void setSumTimerWait(Long sumTimerWait) {
		this.sumTimerWait = sumTimerWait;
	}

	public Long getMinTimerWait() {
		return this.minTimerWait;
	}

	public void setMinTimerWait(Long minTimerWait) {
		this.minTimerWait = minTimerWait;
	}

	public Long getAvgTimerWait() {
		return this.avgTimerWait;
	}

	public void setAvgTimerWait(Long avgTimerWait) {
		this.avgTimerWait = avgTimerWait;
	}

	public Long getMaxTimerWait() {
		return this.maxTimerWait;
	}

	public void setMaxTimerWait(Long maxTimerWait) {
		this.maxTimerWait = maxTimerWait;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EventsWaitsSummaryByThreadByEventNameId))
			return false;
		EventsWaitsSummaryByThreadByEventNameId castOther = (EventsWaitsSummaryByThreadByEventNameId) other;

		return ((this.getThreadId() == castOther.getThreadId()) || (this
				.getThreadId() != null && castOther.getThreadId() != null && this
				.getThreadId().equals(castOther.getThreadId())))
				&& ((this.getEventName() == castOther.getEventName()) || (this
						.getEventName() != null
						&& castOther.getEventName() != null && this
						.getEventName().equals(castOther.getEventName())))
				&& ((this.getCountStar() == castOther.getCountStar()) || (this
						.getCountStar() != null
						&& castOther.getCountStar() != null && this
						.getCountStar().equals(castOther.getCountStar())))
				&& ((this.getSumTimerWait() == castOther.getSumTimerWait()) || (this
						.getSumTimerWait() != null
						&& castOther.getSumTimerWait() != null && this
						.getSumTimerWait().equals(castOther.getSumTimerWait())))
				&& ((this.getMinTimerWait() == castOther.getMinTimerWait()) || (this
						.getMinTimerWait() != null
						&& castOther.getMinTimerWait() != null && this
						.getMinTimerWait().equals(castOther.getMinTimerWait())))
				&& ((this.getAvgTimerWait() == castOther.getAvgTimerWait()) || (this
						.getAvgTimerWait() != null
						&& castOther.getAvgTimerWait() != null && this
						.getAvgTimerWait().equals(castOther.getAvgTimerWait())))
				&& ((this.getMaxTimerWait() == castOther.getMaxTimerWait()) || (this
						.getMaxTimerWait() != null
						&& castOther.getMaxTimerWait() != null && this
						.getMaxTimerWait().equals(castOther.getMaxTimerWait())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getThreadId() == null ? 0 : this.getThreadId().hashCode());
		result = 37 * result
				+ (getEventName() == null ? 0 : this.getEventName().hashCode());
		result = 37 * result
				+ (getCountStar() == null ? 0 : this.getCountStar().hashCode());
		result = 37
				* result
				+ (getSumTimerWait() == null ? 0 : this.getSumTimerWait()
						.hashCode());
		result = 37
				* result
				+ (getMinTimerWait() == null ? 0 : this.getMinTimerWait()
						.hashCode());
		result = 37
				* result
				+ (getAvgTimerWait() == null ? 0 : this.getAvgTimerWait()
						.hashCode());
		result = 37
				* result
				+ (getMaxTimerWait() == null ? 0 : this.getMaxTimerWait()
						.hashCode());
		return result;
	}

}