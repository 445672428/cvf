package com.hibernate.service.pojo;

/**
 * UserroleId entity. @author MyEclipse Persistence Tools
 */

public class UserroleId implements java.io.Serializable {

	// Fields

	private String userid;
	private Sysrole sysrole;

	// Constructors

	/** default constructor */
	public UserroleId() {
	}

	/** full constructor */
	public UserroleId(String userid, Sysrole sysrole) {
		this.userid = userid;
		this.sysrole = sysrole;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Sysrole getSysrole() {
		return this.sysrole;
	}

	public void setSysrole(Sysrole sysrole) {
		this.sysrole = sysrole;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserroleId))
			return false;
		UserroleId castOther = (UserroleId) other;

		return ((this.getUserid() == castOther.getUserid()) || (this
				.getUserid() != null && castOther.getUserid() != null && this
				.getUserid().equals(castOther.getUserid())))
				&& ((this.getSysrole() == castOther.getSysrole()) || (this
						.getSysrole() != null && castOther.getSysrole() != null && this
						.getSysrole().equals(castOther.getSysrole())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37 * result
				+ (getSysrole() == null ? 0 : this.getSysrole().hashCode());
		return result;
	}

}