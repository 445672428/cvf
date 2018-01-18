package com.hibernate.service.pojo;

/**
 * GysypmlControl entity. @author MyEclipse Persistence Tools
 */

public class GysypmlControl implements java.io.Serializable {

	// Fields

	private String id;
	private Ypxx ypxx;
	private String usergysid;
	private String control;
	private String advice;
	private String vchar1;
	private String vchar2;

	// Constructors

	/** default constructor */
	public GysypmlControl() {
	}

	/** minimal constructor */
	public GysypmlControl(String id, Ypxx ypxx, String usergysid, String control) {
		this.id = id;
		this.ypxx = ypxx;
		this.usergysid = usergysid;
		this.control = control;
	}

	/** full constructor */
	public GysypmlControl(String id, Ypxx ypxx, String usergysid,
			String control, String advice, String vchar1, String vchar2) {
		this.id = id;
		this.ypxx = ypxx;
		this.usergysid = usergysid;
		this.control = control;
		this.advice = advice;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Ypxx getYpxx() {
		return this.ypxx;
	}

	public void setYpxx(Ypxx ypxx) {
		this.ypxx = ypxx;
	}

	public String getUsergysid() {
		return this.usergysid;
	}

	public void setUsergysid(String usergysid) {
		this.usergysid = usergysid;
	}

	public String getControl() {
		return this.control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getAdvice() {
		return this.advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
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

}