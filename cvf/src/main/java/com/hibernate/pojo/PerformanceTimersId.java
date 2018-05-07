package com.hibernate.pojo;

/**
 * PerformanceTimersId entity. @author MyEclipse Persistence Tools
 */

public class PerformanceTimersId implements java.io.Serializable {

	// Fields

	private String timerName;
	private Long timerFrequency;
	private Long timerResolution;
	private Long timerOverhead;

	// Constructors

	/** default constructor */
	public PerformanceTimersId() {
	}

	/** minimal constructor */
	public PerformanceTimersId(String timerName) {
		this.timerName = timerName;
	}

	/** full constructor */
	public PerformanceTimersId(String timerName, Long timerFrequency,
			Long timerResolution, Long timerOverhead) {
		this.timerName = timerName;
		this.timerFrequency = timerFrequency;
		this.timerResolution = timerResolution;
		this.timerOverhead = timerOverhead;
	}

	// Property accessors

	public String getTimerName() {
		return this.timerName;
	}

	public void setTimerName(String timerName) {
		this.timerName = timerName;
	}

	public Long getTimerFrequency() {
		return this.timerFrequency;
	}

	public void setTimerFrequency(Long timerFrequency) {
		this.timerFrequency = timerFrequency;
	}

	public Long getTimerResolution() {
		return this.timerResolution;
	}

	public void setTimerResolution(Long timerResolution) {
		this.timerResolution = timerResolution;
	}

	public Long getTimerOverhead() {
		return this.timerOverhead;
	}

	public void setTimerOverhead(Long timerOverhead) {
		this.timerOverhead = timerOverhead;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PerformanceTimersId))
			return false;
		PerformanceTimersId castOther = (PerformanceTimersId) other;

		return ((this.getTimerName() == castOther.getTimerName()) || (this
				.getTimerName() != null && castOther.getTimerName() != null && this
				.getTimerName().equals(castOther.getTimerName())))
				&& ((this.getTimerFrequency() == castOther.getTimerFrequency()) || (this
						.getTimerFrequency() != null
						&& castOther.getTimerFrequency() != null && this
						.getTimerFrequency().equals(
								castOther.getTimerFrequency())))
				&& ((this.getTimerResolution() == castOther
						.getTimerResolution()) || (this.getTimerResolution() != null
						&& castOther.getTimerResolution() != null && this
						.getTimerResolution().equals(
								castOther.getTimerResolution())))
				&& ((this.getTimerOverhead() == castOther.getTimerOverhead()) || (this
						.getTimerOverhead() != null
						&& castOther.getTimerOverhead() != null && this
						.getTimerOverhead()
						.equals(castOther.getTimerOverhead())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTimerName() == null ? 0 : this.getTimerName().hashCode());
		result = 37
				* result
				+ (getTimerFrequency() == null ? 0 : this.getTimerFrequency()
						.hashCode());
		result = 37
				* result
				+ (getTimerResolution() == null ? 0 : this.getTimerResolution()
						.hashCode());
		result = 37
				* result
				+ (getTimerOverhead() == null ? 0 : this.getTimerOverhead()
						.hashCode());
		return result;
	}

}