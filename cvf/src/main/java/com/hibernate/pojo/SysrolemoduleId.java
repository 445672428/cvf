package com.hibernate.pojo;

/**
 * SysrolemoduleId entity. @author MyEclipse Persistence Tools
 */

public class SysrolemoduleId implements java.io.Serializable {

	// Fields

	private String roleid;
	private Sysmodule sysmodule;

	// Constructors

	/** default constructor */
	public SysrolemoduleId() {
	}

	/** full constructor */
	public SysrolemoduleId(String roleid, Sysmodule sysmodule) {
		this.roleid = roleid;
		this.sysmodule = sysmodule;
	}

	// Property accessors

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public Sysmodule getSysmodule() {
		return this.sysmodule;
	}

	public void setSysmodule(Sysmodule sysmodule) {
		this.sysmodule = sysmodule;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SysrolemoduleId))
			return false;
		SysrolemoduleId castOther = (SysrolemoduleId) other;

		return ((this.getRoleid() == castOther.getRoleid()) || (this
				.getRoleid() != null && castOther.getRoleid() != null && this
				.getRoleid().equals(castOther.getRoleid())))
				&& ((this.getSysmodule() == castOther.getSysmodule()) || (this
						.getSysmodule() != null
						&& castOther.getSysmodule() != null && this
						.getSysmodule().equals(castOther.getSysmodule())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRoleid() == null ? 0 : this.getRoleid().hashCode());
		result = 37 * result
				+ (getSysmodule() == null ? 0 : this.getSysmodule().hashCode());
		return result;
	}

}