package com.hibernate.pojo;

/**
 * SetupConsumersId entity. @author MyEclipse Persistence Tools
 */

public class SetupConsumersId implements java.io.Serializable {

	// Fields

	private String name;
	private String enabled;

	// Constructors

	/** default constructor */
	public SetupConsumersId() {
	}

	/** full constructor */
	public SetupConsumersId(String name, String enabled) {
		this.name = name;
		this.enabled = enabled;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SetupConsumersId))
			return false;
		SetupConsumersId castOther = (SetupConsumersId) other;

		return ((this.getName() == castOther.getName()) || (this.getName() != null
				&& castOther.getName() != null && this.getName().equals(
				castOther.getName())))
				&& ((this.getEnabled() == castOther.getEnabled()) || (this
						.getEnabled() != null && castOther.getEnabled() != null && this
						.getEnabled().equals(castOther.getEnabled())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getEnabled() == null ? 0 : this.getEnabled().hashCode());
		return result;
	}

}