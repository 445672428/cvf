package com.hibernate.pojo;

/**
 * UsergysareaId entity. @author MyEclipse Persistence Tools
 */

public class UsergysareaId implements java.io.Serializable {

	// Fields

	private Usergys usergys;
	private String areaid;

	// Constructors

	/** default constructor */
	public UsergysareaId() {
	}

	/** full constructor */
	public UsergysareaId(Usergys usergys, String areaid) {
		this.usergys = usergys;
		this.areaid = areaid;
	}

	// Property accessors

	public Usergys getUsergys() {
		return this.usergys;
	}

	public void setUsergys(Usergys usergys) {
		this.usergys = usergys;
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
		if (!(other instanceof UsergysareaId))
			return false;
		UsergysareaId castOther = (UsergysareaId) other;

		return ((this.getUsergys() == castOther.getUsergys()) || (this
				.getUsergys() != null && castOther.getUsergys() != null && this
				.getUsergys().equals(castOther.getUsergys())))
				&& ((this.getAreaid() == castOther.getAreaid()) || (this
						.getAreaid() != null && castOther.getAreaid() != null && this
						.getAreaid().equals(castOther.getAreaid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsergys() == null ? 0 : this.getUsergys().hashCode());
		result = 37 * result
				+ (getAreaid() == null ? 0 : this.getAreaid().hashCode());
		return result;
	}

}