package com.hibernate.pojo;

import java.sql.Timestamp;

/**
 * Event entity. @author MyEclipse Persistence Tools
 */

public class Event implements java.io.Serializable {

	// Fields

	private EventId id;
	private String body;
	private String definer;
	private Timestamp executeAt;
	private Integer intervalValue;
	private String intervalField;
	private Timestamp created;
	private Timestamp modified;
	private Timestamp lastExecuted;
	private Timestamp starts;
	private Timestamp ends;
	private String status;
	private String onCompletion;
	private String sqlMode;
	private String comment;
	private Integer originator;
	private String timeZone;
	private String characterSetClient;
	private String collationConnection;
	private String dbCollation;
	private String bodyUtf8;

	// Constructors

	/** default constructor */
	public Event() {
	}

	/** minimal constructor */
	public Event(EventId id, String body, String definer, Timestamp created,
			Timestamp modified, String status, String onCompletion,
			String sqlMode, String comment, Integer originator, String timeZone) {
		this.id = id;
		this.body = body;
		this.definer = definer;
		this.created = created;
		this.modified = modified;
		this.status = status;
		this.onCompletion = onCompletion;
		this.sqlMode = sqlMode;
		this.comment = comment;
		this.originator = originator;
		this.timeZone = timeZone;
	}

	/** full constructor */
	public Event(EventId id, String body, String definer, Timestamp executeAt,
			Integer intervalValue, String intervalField, Timestamp created,
			Timestamp modified, Timestamp lastExecuted, Timestamp starts,
			Timestamp ends, String status, String onCompletion, String sqlMode,
			String comment, Integer originator, String timeZone,
			String characterSetClient, String collationConnection,
			String dbCollation, String bodyUtf8) {
		this.id = id;
		this.body = body;
		this.definer = definer;
		this.executeAt = executeAt;
		this.intervalValue = intervalValue;
		this.intervalField = intervalField;
		this.created = created;
		this.modified = modified;
		this.lastExecuted = lastExecuted;
		this.starts = starts;
		this.ends = ends;
		this.status = status;
		this.onCompletion = onCompletion;
		this.sqlMode = sqlMode;
		this.comment = comment;
		this.originator = originator;
		this.timeZone = timeZone;
		this.characterSetClient = characterSetClient;
		this.collationConnection = collationConnection;
		this.dbCollation = dbCollation;
		this.bodyUtf8 = bodyUtf8;
	}

	// Property accessors

	public EventId getId() {
		return this.id;
	}

	public void setId(EventId id) {
		this.id = id;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDefiner() {
		return this.definer;
	}

	public void setDefiner(String definer) {
		this.definer = definer;
	}

	public Timestamp getExecuteAt() {
		return this.executeAt;
	}

	public void setExecuteAt(Timestamp executeAt) {
		this.executeAt = executeAt;
	}

	public Integer getIntervalValue() {
		return this.intervalValue;
	}

	public void setIntervalValue(Integer intervalValue) {
		this.intervalValue = intervalValue;
	}

	public String getIntervalField() {
		return this.intervalField;
	}

	public void setIntervalField(String intervalField) {
		this.intervalField = intervalField;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public Timestamp getLastExecuted() {
		return this.lastExecuted;
	}

	public void setLastExecuted(Timestamp lastExecuted) {
		this.lastExecuted = lastExecuted;
	}

	public Timestamp getStarts() {
		return this.starts;
	}

	public void setStarts(Timestamp starts) {
		this.starts = starts;
	}

	public Timestamp getEnds() {
		return this.ends;
	}

	public void setEnds(Timestamp ends) {
		this.ends = ends;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOnCompletion() {
		return this.onCompletion;
	}

	public void setOnCompletion(String onCompletion) {
		this.onCompletion = onCompletion;
	}

	public String getSqlMode() {
		return this.sqlMode;
	}

	public void setSqlMode(String sqlMode) {
		this.sqlMode = sqlMode;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getOriginator() {
		return this.originator;
	}

	public void setOriginator(Integer originator) {
		this.originator = originator;
	}

	public String getTimeZone() {
		return this.timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getCharacterSetClient() {
		return this.characterSetClient;
	}

	public void setCharacterSetClient(String characterSetClient) {
		this.characterSetClient = characterSetClient;
	}

	public String getCollationConnection() {
		return this.collationConnection;
	}

	public void setCollationConnection(String collationConnection) {
		this.collationConnection = collationConnection;
	}

	public String getDbCollation() {
		return this.dbCollation;
	}

	public void setDbCollation(String dbCollation) {
		this.dbCollation = dbCollation;
	}

	public String getBodyUtf8() {
		return this.bodyUtf8;
	}

	public void setBodyUtf8(String bodyUtf8) {
		this.bodyUtf8 = bodyUtf8;
	}

}