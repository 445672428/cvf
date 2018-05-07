package com.hibernate.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Sysuser entity. @author MyEclipse Persistence Tools
 */

public class Sysuser implements java.io.Serializable {

	// Fields

	private String id;
	private String userid;
	private String username;
	private String groupid;
	private String pwd;
	private String contact;
	private String addr;
	private String email;
	private String userstate;
	private String remark;
	private Timestamp createtime;
	private String sex;
	private String phone;
	private String movephone;
	private String fax;
	private String lastupdate;
	private String vchar1;
	private String vchar2;
	private String vchar3;
	private String vchar4;
	private String vchar5;
	private String sysid;
	private Set userareas = new HashSet(0);
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	// Constructors

	/** default constructor */
	public Sysuser() {
	}

	/** minimal constructor */
	public Sysuser(String id, String userid, String username, String groupid,
			String pwd, String userstate) {
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.groupid = groupid;
		this.pwd = pwd;
		this.userstate = userstate;
	}

	/** full constructor */
	public Sysuser(String id, String userid, String username, String groupid,
			String pwd, String contact, String addr, String email,
			String userstate, String remark, Timestamp createtime, String sex,
			String phone, String movephone, String fax, String lastupdate,
			String vchar1, String vchar2, String vchar3, String vchar4,
			String vchar5, String sysid, Set userareas) {
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.groupid = groupid;
		this.pwd = pwd;
		this.contact = contact;
		this.addr = addr;
		this.email = email;
		this.userstate = userstate;
		this.remark = remark;
		this.createtime = createtime;
		this.sex = sex;
		this.phone = phone;
		this.movephone = movephone;
		this.fax = fax;
		this.lastupdate = lastupdate;
		this.vchar1 = vchar1;
		this.vchar2 = vchar2;
		this.vchar3 = vchar3;
		this.vchar4 = vchar4;
		this.vchar5 = vchar5;
		this.sysid = sysid;
		this.userareas = userareas;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserstate() {
		return this.userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMovephone() {
		return this.movephone;
	}

	public void setMovephone(String movephone) {
		this.movephone = movephone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getLastupdate() {
		return this.lastupdate;
	}

	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
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

	public String getVchar4() {
		return this.vchar4;
	}

	public void setVchar4(String vchar4) {
		this.vchar4 = vchar4;
	}

	public String getVchar5() {
		return this.vchar5;
	}

	public void setVchar5(String vchar5) {
		this.vchar5 = vchar5;
	}

	public String getSysid() {
		return this.sysid;
	}

	public void setSysid(String sysid) {
		this.sysid = sysid;
	}

	public Set getUserareas() {
		return this.userareas;
	}

	public void setUserareas(Set userareas) {
		this.userareas = userareas;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

}