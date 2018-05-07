package com.hibernate.pojo;

/**
 * SetupTimersId entity. @author MyEclipse Persistence Tools
 */

public class SetupTimersId implements java.io.Serializable {

	// Fields

	private String name;
	private String timerName;

	// Constructors

	/** default constructor */
	public SetupTimersId() {
	}

	/** full constructor */
	public SetupTimersId(String name, String timerName) {
		this.name = name;
		this.timerName = timerName;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTimerName() {
		return this.timerName;
	}

	public void setTimerName(String timerName) {
		this.timerName = timerName;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SetupTimersId))
			return false;
		SetupTimersId castOther = (SetupTimersId) other;

		return ((this.getName() == castOther.getName()) || (this.getName() != null
				&& castOther.getName() != null && this.getName().equals(
				castOther.getName())))
				&& ((this.getTimerName() == castOther.getTimerName()) || (this
						.getTimerName() != null
						&& castOther.getTimerName() != null && this
						.getTimerName().equals(castOther.getTimerName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getTimerName() == null ? 0 : this.getTimerName().hashCode());
		return result;
	}

}