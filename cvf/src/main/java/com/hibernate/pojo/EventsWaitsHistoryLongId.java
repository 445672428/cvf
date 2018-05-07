package com.hibernate.pojo;

/**
 * EventsWaitsHistoryLongId entity. @author MyEclipse Persistence Tools
 */

public class EventsWaitsHistoryLongId implements java.io.Serializable {

	// Fields

	private Integer threadId;
	private Long eventId;
	private String eventName;
	private String source;
	private Long timerStart;
	private Long timerEnd;
	private Long timerWait;
	private Integer spins;
	private String objectSchema;
	private String objectName;
	private String objectType;
	private Long objectInstanceBegin;
	private Long nestingEventId;
	private String operation;
	private Long numberOfBytes;
	private Integer flags;

	// Constructors

	/** default constructor */
	public EventsWaitsHistoryLongId() {
	}

	/** minimal constructor */
	public EventsWaitsHistoryLongId(Integer threadId, Long eventId,
			String eventName, Long objectInstanceBegin, String operation) {
		this.threadId = threadId;
		this.eventId = eventId;
		this.eventName = eventName;
		this.objectInstanceBegin = objectInstanceBegin;
		this.operation = operation;
	}

	/** full constructor */
	public EventsWaitsHistoryLongId(Integer threadId, Long eventId,
			String eventName, String source, Long timerStart, Long timerEnd,
			Long timerWait, Integer spins, String objectSchema,
			String objectName, String objectType, Long objectInstanceBegin,
			Long nestingEventId, String operation, Long numberOfBytes,
			Integer flags) {
		this.threadId = threadId;
		this.eventId = eventId;
		this.eventName = eventName;
		this.source = source;
		this.timerStart = timerStart;
		this.timerEnd = timerEnd;
		this.timerWait = timerWait;
		this.spins = spins;
		this.objectSchema = objectSchema;
		this.objectName = objectName;
		this.objectType = objectType;
		this.objectInstanceBegin = objectInstanceBegin;
		this.nestingEventId = nestingEventId;
		this.operation = operation;
		this.numberOfBytes = numberOfBytes;
		this.flags = flags;
	}

	// Property accessors

	public Integer getThreadId() {
		return this.threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	public Long getEventId() {
		return this.eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getTimerStart() {
		return this.timerStart;
	}

	public void setTimerStart(Long timerStart) {
		this.timerStart = timerStart;
	}

	public Long getTimerEnd() {
		return this.timerEnd;
	}

	public void setTimerEnd(Long timerEnd) {
		this.timerEnd = timerEnd;
	}

	public Long getTimerWait() {
		return this.timerWait;
	}

	public void setTimerWait(Long timerWait) {
		this.timerWait = timerWait;
	}

	public Integer getSpins() {
		return this.spins;
	}

	public void setSpins(Integer spins) {
		this.spins = spins;
	}

	public String getObjectSchema() {
		return this.objectSchema;
	}

	public void setObjectSchema(String objectSchema) {
		this.objectSchema = objectSchema;
	}

	public String getObjectName() {
		return this.objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public Long getObjectInstanceBegin() {
		return this.objectInstanceBegin;
	}

	public void setObjectInstanceBegin(Long objectInstanceBegin) {
		this.objectInstanceBegin = objectInstanceBegin;
	}

	public Long getNestingEventId() {
		return this.nestingEventId;
	}

	public void setNestingEventId(Long nestingEventId) {
		this.nestingEventId = nestingEventId;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Long getNumberOfBytes() {
		return this.numberOfBytes;
	}

	public void setNumberOfBytes(Long numberOfBytes) {
		this.numberOfBytes = numberOfBytes;
	}

	public Integer getFlags() {
		return this.flags;
	}

	public void setFlags(Integer flags) {
		this.flags = flags;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EventsWaitsHistoryLongId))
			return false;
		EventsWaitsHistoryLongId castOther = (EventsWaitsHistoryLongId) other;

		return ((this.getThreadId() == castOther.getThreadId()) || (this
				.getThreadId() != null && castOther.getThreadId() != null && this
				.getThreadId().equals(castOther.getThreadId())))
				&& ((this.getEventId() == castOther.getEventId()) || (this
						.getEventId() != null && castOther.getEventId() != null && this
						.getEventId().equals(castOther.getEventId())))
				&& ((this.getEventName() == castOther.getEventName()) || (this
						.getEventName() != null
						&& castOther.getEventName() != null && this
						.getEventName().equals(castOther.getEventName())))
				&& ((this.getSource() == castOther.getSource()) || (this
						.getSource() != null && castOther.getSource() != null && this
						.getSource().equals(castOther.getSource())))
				&& ((this.getTimerStart() == castOther.getTimerStart()) || (this
						.getTimerStart() != null
						&& castOther.getTimerStart() != null && this
						.getTimerStart().equals(castOther.getTimerStart())))
				&& ((this.getTimerEnd() == castOther.getTimerEnd()) || (this
						.getTimerEnd() != null
						&& castOther.getTimerEnd() != null && this
						.getTimerEnd().equals(castOther.getTimerEnd())))
				&& ((this.getTimerWait() == castOther.getTimerWait()) || (this
						.getTimerWait() != null
						&& castOther.getTimerWait() != null && this
						.getTimerWait().equals(castOther.getTimerWait())))
				&& ((this.getSpins() == castOther.getSpins()) || (this
						.getSpins() != null && castOther.getSpins() != null && this
						.getSpins().equals(castOther.getSpins())))
				&& ((this.getObjectSchema() == castOther.getObjectSchema()) || (this
						.getObjectSchema() != null
						&& castOther.getObjectSchema() != null && this
						.getObjectSchema().equals(castOther.getObjectSchema())))
				&& ((this.getObjectName() == castOther.getObjectName()) || (this
						.getObjectName() != null
						&& castOther.getObjectName() != null && this
						.getObjectName().equals(castOther.getObjectName())))
				&& ((this.getObjectType() == castOther.getObjectType()) || (this
						.getObjectType() != null
						&& castOther.getObjectType() != null && this
						.getObjectType().equals(castOther.getObjectType())))
				&& ((this.getObjectInstanceBegin() == castOther
						.getObjectInstanceBegin()) || (this
						.getObjectInstanceBegin() != null
						&& castOther.getObjectInstanceBegin() != null && this
						.getObjectInstanceBegin().equals(
								castOther.getObjectInstanceBegin())))
				&& ((this.getNestingEventId() == castOther.getNestingEventId()) || (this
						.getNestingEventId() != null
						&& castOther.getNestingEventId() != null && this
						.getNestingEventId().equals(
								castOther.getNestingEventId())))
				&& ((this.getOperation() == castOther.getOperation()) || (this
						.getOperation() != null
						&& castOther.getOperation() != null && this
						.getOperation().equals(castOther.getOperation())))
				&& ((this.getNumberOfBytes() == castOther.getNumberOfBytes()) || (this
						.getNumberOfBytes() != null
						&& castOther.getNumberOfBytes() != null && this
						.getNumberOfBytes()
						.equals(castOther.getNumberOfBytes())))
				&& ((this.getFlags() == castOther.getFlags()) || (this
						.getFlags() != null && castOther.getFlags() != null && this
						.getFlags().equals(castOther.getFlags())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getThreadId() == null ? 0 : this.getThreadId().hashCode());
		result = 37 * result
				+ (getEventId() == null ? 0 : this.getEventId().hashCode());
		result = 37 * result
				+ (getEventName() == null ? 0 : this.getEventName().hashCode());
		result = 37 * result
				+ (getSource() == null ? 0 : this.getSource().hashCode());
		result = 37
				* result
				+ (getTimerStart() == null ? 0 : this.getTimerStart()
						.hashCode());
		result = 37 * result
				+ (getTimerEnd() == null ? 0 : this.getTimerEnd().hashCode());
		result = 37 * result
				+ (getTimerWait() == null ? 0 : this.getTimerWait().hashCode());
		result = 37 * result
				+ (getSpins() == null ? 0 : this.getSpins().hashCode());
		result = 37
				* result
				+ (getObjectSchema() == null ? 0 : this.getObjectSchema()
						.hashCode());
		result = 37
				* result
				+ (getObjectName() == null ? 0 : this.getObjectName()
						.hashCode());
		result = 37
				* result
				+ (getObjectType() == null ? 0 : this.getObjectType()
						.hashCode());
		result = 37
				* result
				+ (getObjectInstanceBegin() == null ? 0 : this
						.getObjectInstanceBegin().hashCode());
		result = 37
				* result
				+ (getNestingEventId() == null ? 0 : this.getNestingEventId()
						.hashCode());
		result = 37 * result
				+ (getOperation() == null ? 0 : this.getOperation().hashCode());
		result = 37
				* result
				+ (getNumberOfBytes() == null ? 0 : this.getNumberOfBytes()
						.hashCode());
		result = 37 * result
				+ (getFlags() == null ? 0 : this.getFlags().hashCode());
		return result;
	}

}