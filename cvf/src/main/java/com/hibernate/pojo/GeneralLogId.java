package com.hibernate.pojo;

import java.sql.Timestamp;

/**
 * GeneralLogId entity. @author MyEclipse Persistence Tools
 */

public class GeneralLogId implements java.io.Serializable {

	// Fields

	private Timestamp eventTime;
	private String userHost;
	private Integer threadId;
	private Integer serverId;
	private String commandType;
	private String argument;

	// Constructors

	/** default constructor */
	public GeneralLogId() {
	}

	/** full constructor */
	public GeneralLogId(Timestamp eventTime, String userHost, Integer threadId,
			Integer serverId, String commandType, String argument) {
		this.eventTime = eventTime;
		this.userHost = userHost;
		this.threadId = threadId;
		this.serverId = serverId;
		this.commandType = commandType;
		this.argument = argument;
	}

	// Property accessors

	public Timestamp getEventTime() {
		return this.eventTime;
	}

	public void setEventTime(Timestamp eventTime) {
		this.eventTime = eventTime;
	}

	public String getUserHost() {
		return this.userHost;
	}

	public void setUserHost(String userHost) {
		this.userHost = userHost;
	}

	public Integer getThreadId() {
		return this.threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	public Integer getServerId() {
		return this.serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	public String getCommandType() {
		return this.commandType;
	}

	public void setCommandType(String commandType) {
		this.commandType = commandType;
	}

	public String getArgument() {
		return this.argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GeneralLogId))
			return false;
		GeneralLogId castOther = (GeneralLogId) other;

		return ((this.getEventTime() == castOther.getEventTime()) || (this
				.getEventTime() != null && castOther.getEventTime() != null && this
				.getEventTime().equals(castOther.getEventTime())))
				&& ((this.getUserHost() == castOther.getUserHost()) || (this
						.getUserHost() != null
						&& castOther.getUserHost() != null && this
						.getUserHost().equals(castOther.getUserHost())))
				&& ((this.getThreadId() == castOther.getThreadId()) || (this
						.getThreadId() != null
						&& castOther.getThreadId() != null && this
						.getThreadId().equals(castOther.getThreadId())))
				&& ((this.getServerId() == castOther.getServerId()) || (this
						.getServerId() != null
						&& castOther.getServerId() != null && this
						.getServerId().equals(castOther.getServerId())))
				&& ((this.getCommandType() == castOther.getCommandType()) || (this
						.getCommandType() != null
						&& castOther.getCommandType() != null && this
						.getCommandType().equals(castOther.getCommandType())))
				&& ((this.getArgument() == castOther.getArgument()) || (this
						.getArgument() != null
						&& castOther.getArgument() != null && this
						.getArgument().equals(castOther.getArgument())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEventTime() == null ? 0 : this.getEventTime().hashCode());
		result = 37 * result
				+ (getUserHost() == null ? 0 : this.getUserHost().hashCode());
		result = 37 * result
				+ (getThreadId() == null ? 0 : this.getThreadId().hashCode());
		result = 37 * result
				+ (getServerId() == null ? 0 : this.getServerId().hashCode());
		result = 37
				* result
				+ (getCommandType() == null ? 0 : this.getCommandType()
						.hashCode());
		result = 37 * result
				+ (getArgument() == null ? 0 : this.getArgument().hashCode());
		return result;
	}

}