package com.hibernate.service.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Sysrole entity. @author MyEclipse Persistence Tools
 */

public class Sysrole implements java.io.Serializable {

	// Fields

	private String id;
	private String rolename;
	private String groupid;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private Set userroles = new HashSet(0);

	// Constructors

	/** default constructor */
	public Sysrole() {
	}

	/** minimal constructor */
	public Sysrole(String id, String rolename, String groupid) {
		this.id = id;
		this.rolename = rolename;
		this.groupid = groupid;
	}

	/** full constructor */
	public Sysrole(String id, String rolename, String groupid, String vchar1,
			String vchar2, String vchar3, Set userroles) {
		this.id = id;
		this.rolename = rolename;
		this.groupid = groupid;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.userroles = userroles;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
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

	public Set getUserroles() {
		return this.userroles;
	}

	public void setUserroles(Set userroles) {
		this.userroles = userroles;
	}

}