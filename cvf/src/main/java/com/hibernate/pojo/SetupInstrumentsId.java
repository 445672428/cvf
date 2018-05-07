package com.hibernate.pojo;

/**
 * SetupInstrumentsId entity. @author MyEclipse Persistence Tools
 */

public class SetupInstrumentsId implements java.io.Serializable {

	// Fields

	private String name;
	private String enabled;
	private String timed;

	// Constructors

	/** default constructor */
	public SetupInstrumentsId() {
	}

	/** full constructor */
	public SetupInstrumentsId(String name, String enabled, String timed) {
		this.name = name;
		this.enabled = enabled;
		this.timed = timed;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getTimed() {
		return this.timed;
	}

	public void setTimed(String timed) {
		this.timed = timed;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SetupInstrumentsId))
			return false;
		SetupInstrumentsId castOther = (SetupInstrumentsId) other;

		return ((this.getName() == castOther.getName()) || (this.getName() != null
				&& castOther.getName() != null && this.getName().equals(
				castOther.getName())))
				&& ((this.getEnabled() == castOther.getEnabled()) || (this
						.getEnabled() != null && castOther.getEnabled() != null && this
						.getEnabled().equals(castOther.getEnabled())))
				&& ((this.getTimed() == castOther.getTimed()) || (this
						.getTimed() != null && castOther.getTimed() != null && this
						.getTimed().equals(castOther.getTimed())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getEnabled() == null ? 0 : this.getEnabled().hashCode());
		result = 37 * result
				+ (getTimed() == null ? 0 : this.getTimed().hashCode());
		return result;
	}

}