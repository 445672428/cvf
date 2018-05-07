package com.hibernate.pojo;

/**
 * ThreadsId entity. @author MyEclipse Persistence Tools
 */

public class ThreadsId implements java.io.Serializable {

	// Fields

	private Integer threadId;
	private Integer processlistId;
	private String name;

	// Constructors

	/** default constructor */
	public ThreadsId() {
	}

	/** minimal constructor */
	public ThreadsId(Integer threadId, String name) {
		this.threadId = threadId;
		this.name = name;
	}

	/** full constructor */
	public ThreadsId(Integer threadId, Integer processlistId, String name) {
		this.threadId = threadId;
		this.processlistId = processlistId;
		this.name = name;
	}

	// Property accessors

	public Integer getThreadId() {
		return this.threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	public Integer getProcesslistId() {
		return this.processlistId;
	}

	public void setProcesslistId(Integer processlistId) {
		this.processlistId = processlistId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ThreadsId))
			return false;
		ThreadsId castOther = (ThreadsId) other;

		return ((this.getThreadId() == castOther.getThreadId()) || (this
				.getThreadId() != null && castOther.getThreadId() != null && this
				.getThreadId().equals(castOther.getThreadId())))
				&& ((this.getProcesslistId() == castOther.getProcesslistId()) || (this
						.getProcesslistId() != null
						&& castOther.getProcesslistId() != null && this
						.getProcesslistId()
						.equals(castOther.getProcesslistId())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getThreadId() == null ? 0 : this.getThreadId().hashCode());
		result = 37
				* result
				+ (getProcesslistId() == null ? 0 : this.getProcesslistId()
						.hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		return result;
	}

}