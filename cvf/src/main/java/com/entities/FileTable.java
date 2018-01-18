package com.entities;

import java.io.Serializable;

public class FileTable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7683431185320168295L;
	
	private String id;
	
	private String userid;
	private String filename;
	private Integer level = 0;
	private Boolean ishidden = false;
	private String parentid;
	private String description;
	private String subName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Boolean getIshidden() {
		return ishidden;
	}
	public void setIshidden(Boolean ishidden) {
		this.ishidden = ishidden;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public FileTable(String id, String userid, String filename, Integer level,
			Boolean ishidden, String parentid, String description,
			String subName) {
		super();
		this.id = id;
		this.userid = userid;
		this.filename = filename;
		this.level = level;
		this.ishidden = ishidden;
		this.parentid = parentid;
		this.description = description;
		this.subName = subName;
	}
	public FileTable() {
		super();
	}
	@Override
	public String toString() {
		return "FileTable [id=" + id + ", userid=" + userid + ", filename="
				+ filename + ", level=" + level + ", ishidden=" + ishidden
				+ ", parentid=" + parentid + ", description=" + description
				+ ", subName=" + subName + "]";
	}
	
}
