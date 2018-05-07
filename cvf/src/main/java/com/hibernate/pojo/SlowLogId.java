package com.hibernate.pojo;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * SlowLogId entity. @author MyEclipse Persistence Tools
 */

public class SlowLogId implements java.io.Serializable {

	// Fields

	private Timestamp startTime;
	private String userHost;
	private Time queryTime;
	private Time lockTime;
	private Integer rowsSent;
	private Integer rowsExamined;
	private String db;
	private Integer lastInsertId;
	private Integer insertId;
	private Integer serverId;
	private String sqlText;

	// Constructors

	/** default constructor */
	public SlowLogId() {
	}

	/** full constructor */
	public SlowLogId(Timestamp startTime, String userHost, Time queryTime,
			Time lockTime, Integer rowsSent, Integer rowsExamined, String db,
			Integer lastInsertId, Integer insertId, Integer serverId,
			String sqlText) {
		this.startTime = startTime;
		this.userHost = userHost;
		this.queryTime = queryTime;
		this.lockTime = lockTime;
		this.rowsSent = rowsSent;
		this.rowsExamined = rowsExamined;
		this.db = db;
		this.lastInsertId = lastInsertId;
		this.insertId = insertId;
		this.serverId = serverId;
		this.sqlText = sqlText;
	}

	// Property accessors

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public String getUserHost() {
		return this.userHost;
	}

	public void setUserHost(String userHost) {
		this.userHost = userHost;
	}

	public Time getQueryTime() {
		return this.queryTime;
	}

	public void setQueryTime(Time queryTime) {
		this.queryTime = queryTime;
	}

	public Time getLockTime() {
		return this.lockTime;
	}

	public void setLockTime(Time lockTime) {
		this.lockTime = lockTime;
	}

	public Integer getRowsSent() {
		return this.rowsSent;
	}

	public void setRowsSent(Integer rowsSent) {
		this.rowsSent = rowsSent;
	}

	public Integer getRowsExamined() {
		return this.rowsExamined;
	}

	public void setRowsExamined(Integer rowsExamined) {
		this.rowsExamined = rowsExamined;
	}

	public String getDb() {
		return this.db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public Integer getLastInsertId() {
		return this.lastInsertId;
	}

	public void setLastInsertId(Integer lastInsertId) {
		this.lastInsertId = lastInsertId;
	}

	public Integer getInsertId() {
		return this.insertId;
	}

	public void setInsertId(Integer insertId) {
		this.insertId = insertId;
	}

	public Integer getServerId() {
		return this.serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	public String getSqlText() {
		return this.sqlText;
	}

	public void setSqlText(String sqlText) {
		this.sqlText = sqlText;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SlowLogId))
			return false;
		SlowLogId castOther = (SlowLogId) other;

		return ((this.getStartTime() == castOther.getStartTime()) || (this
				.getStartTime() != null && castOther.getStartTime() != null && this
				.getStartTime().equals(castOther.getStartTime())))
				&& ((this.getUserHost() == castOther.getUserHost()) || (this
						.getUserHost() != null
						&& castOther.getUserHost() != null && this
						.getUserHost().equals(castOther.getUserHost())))
				&& ((this.getQueryTime() == castOther.getQueryTime()) || (this
						.getQueryTime() != null
						&& castOther.getQueryTime() != null && this
						.getQueryTime().equals(castOther.getQueryTime())))
				&& ((this.getLockTime() == castOther.getLockTime()) || (this
						.getLockTime() != null
						&& castOther.getLockTime() != null && this
						.getLockTime().equals(castOther.getLockTime())))
				&& ((this.getRowsSent() == castOther.getRowsSent()) || (this
						.getRowsSent() != null
						&& castOther.getRowsSent() != null && this
						.getRowsSent().equals(castOther.getRowsSent())))
				&& ((this.getRowsExamined() == castOther.getRowsExamined()) || (this
						.getRowsExamined() != null
						&& castOther.getRowsExamined() != null && this
						.getRowsExamined().equals(castOther.getRowsExamined())))
				&& ((this.getDb() == castOther.getDb()) || (this.getDb() != null
						&& castOther.getDb() != null && this.getDb().equals(
						castOther.getDb())))
				&& ((this.getLastInsertId() == castOther.getLastInsertId()) || (this
						.getLastInsertId() != null
						&& castOther.getLastInsertId() != null && this
						.getLastInsertId().equals(castOther.getLastInsertId())))
				&& ((this.getInsertId() == castOther.getInsertId()) || (this
						.getInsertId() != null
						&& castOther.getInsertId() != null && this
						.getInsertId().equals(castOther.getInsertId())))
				&& ((this.getServerId() == castOther.getServerId()) || (this
						.getServerId() != null
						&& castOther.getServerId() != null && this
						.getServerId().equals(castOther.getServerId())))
				&& ((this.getSqlText() == castOther.getSqlText()) || (this
						.getSqlText() != null && castOther.getSqlText() != null && this
						.getSqlText().equals(castOther.getSqlText())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getStartTime() == null ? 0 : this.getStartTime().hashCode());
		result = 37 * result
				+ (getUserHost() == null ? 0 : this.getUserHost().hashCode());
		result = 37 * result
				+ (getQueryTime() == null ? 0 : this.getQueryTime().hashCode());
		result = 37 * result
				+ (getLockTime() == null ? 0 : this.getLockTime().hashCode());
		result = 37 * result
				+ (getRowsSent() == null ? 0 : this.getRowsSent().hashCode());
		result = 37
				* result
				+ (getRowsExamined() == null ? 0 : this.getRowsExamined()
						.hashCode());
		result = 37 * result + (getDb() == null ? 0 : this.getDb().hashCode());
		result = 37
				* result
				+ (getLastInsertId() == null ? 0 : this.getLastInsertId()
						.hashCode());
		result = 37 * result
				+ (getInsertId() == null ? 0 : this.getInsertId().hashCode());
		result = 37 * result
				+ (getServerId() == null ? 0 : this.getServerId().hashCode());
		result = 37 * result
				+ (getSqlText() == null ? 0 : this.getSqlText().hashCode());
		return result;
	}

}