package com.hibernate.service.pojo;

/**
 * ErrorTaskBackupId entity. @author MyEclipse Persistence Tools
 */

public class ErrorTaskBackupId implements java.io.Serializable {

	// Fields

	private String taskid;
	private String wsurl;
	private String wsmethod;
	private String wsnamespace;
	private String vchar1;
	private String vchar2;
	private String vchar3;

	// Constructors

	/** default constructor */
	public ErrorTaskBackupId() {
	}

	/** full constructor */
	public ErrorTaskBackupId(String taskid, String wsurl, String wsmethod,
			String wsnamespace, String vchar1, String vchar2, String vchar3) {
		this.taskid = taskid;
		this.wsurl = wsurl;
		this.wsmethod = wsmethod;
		this.wsnamespace = wsnamespace;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
	}

	// Property accessors

	public String getTaskid() {
		return this.taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getWsurl() {
		return this.wsurl;
	}

	public void setWsurl(String wsurl) {
		this.wsurl = wsurl;
	}

	public String getWsmethod() {
		return this.wsmethod;
	}

	public void setWsmethod(String wsmethod) {
		this.wsmethod = wsmethod;
	}

	public String getWsnamespace() {
		return this.wsnamespace;
	}

	public void setWsnamespace(String wsnamespace) {
		this.wsnamespace = wsnamespace;
	}

	public String getVchar1() {
		return this.vchar1;
	}

	public void setVchar1(String vchar1) {
		this.vchar1 = vchar1;
	}

	public String getVchar2() {
		return this.vchar2;
	}

	public void setVchar2(String vchar2) {
		this.vchar2 = vchar2;
	}

	public String getVchar3() {
		return this.vchar3;
	}

	public void setVchar3(String vchar3) {
		this.vchar3 = vchar3;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ErrorTaskBackupId))
			return false;
		ErrorTaskBackupId castOther = (ErrorTaskBackupId) other;

		return ((this.getTaskid() == castOther.getTaskid()) || (this
				.getTaskid() != null && castOther.getTaskid() != null && this
				.getTaskid().equals(castOther.getTaskid())))
				&& ((this.getWsurl() == castOther.getWsurl()) || (this
						.getWsurl() != null && castOther.getWsurl() != null && this
						.getWsurl().equals(castOther.getWsurl())))
				&& ((this.getWsmethod() == castOther.getWsmethod()) || (this
						.getWsmethod() != null
						&& castOther.getWsmethod() != null && this
						.getWsmethod().equals(castOther.getWsmethod())))
				&& ((this.getWsnamespace() == castOther.getWsnamespace()) || (this
						.getWsnamespace() != null
						&& castOther.getWsnamespace() != null && this
						.getWsnamespace().equals(castOther.getWsnamespace())))
				&& ((this.getVchar1() == castOther.getVchar1()) || (this
						.getVchar1() != null && castOther.getVchar1() != null && this
						.getVchar1().equals(castOther.getVchar1())))
				&& ((this.getVchar2() == castOther.getVchar2()) || (this
						.getVchar2() != null && castOther.getVchar2() != null && this
						.getVchar2().equals(castOther.getVchar2())))
				&& ((this.getVchar3() == castOther.getVchar3()) || (this
						.getVchar3() != null && castOther.getVchar3() != null && this
						.getVchar3().equals(castOther.getVchar3())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTaskid() == null ? 0 : this.getTaskid().hashCode());
		result = 37 * result
				+ (getWsurl() == null ? 0 : this.getWsurl().hashCode());
		result = 37 * result
				+ (getWsmethod() == null ? 0 : this.getWsmethod().hashCode());
		result = 37
				* result
				+ (getWsnamespace() == null ? 0 : this.getWsnamespace()
						.hashCode());
		result = 37 * result
				+ (getVchar1() == null ? 0 : this.getVchar1().hashCode());
		result = 37 * result
				+ (getVchar2() == null ? 0 : this.getVchar2().hashCode());
		result = 37 * result
				+ (getVchar3() == null ? 0 : this.getVchar3().hashCode());
		return result;
	}

}