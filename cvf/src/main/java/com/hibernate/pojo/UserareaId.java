package com.hibernate.pojo;

/**
 * UserareaId entity. @author MyEclipse Persistence Tools
 */

public class UserareaId implements java.io.Serializable {

	// Fields

	private Sysuser sysuser;
	private String areaid;

	// Constructors

	/** default constructor */
	public UserareaId() {
	}

	/** full constructor */
	public UserareaId(Sysuser sysuser, String areaid) {
		this.sysuser = sysuser;
		this.areaid = areaid;
	}

	// Property accessors

	public Sysuser getSysuser() {
		return this.sysuser;
	}

	public void setSysuser(Sysuser sysuser) {
		this.sysuser = sysuser;
	}

	public String getAreaid() {
		return this.areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserareaId))
			return false;
		UserareaId castOther = (UserareaId) other;

		return ((this.getSysuser() == castOther.getSysuser()) || (this
				.getSysuser() != null && castOther.getSysuser() != null && this
				.getSysuser().equals(castOther.getSysuser())))
				&& ((this.getAreaid() == castOther.getAreaid()) || (this
						.getAreaid() != null && castOther.getAreaid() != null && this
						.getAreaid().equals(castOther.getAreaid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSysuser() == null ? 0 : this.getSysuser().hashCode());
		result = 37 * result
				+ (getAreaid() == null ? 0 : this.getAreaid().hashCode());
		return result;
	}

}