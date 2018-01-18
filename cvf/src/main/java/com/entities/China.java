package com.entities;

import java.io.Serializable;

public class China implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5872697982980953672L;
	private String name;
	private String code;
	private String parentcode;
	//private List<China> chinas;
	public China(String name,String code,String parentcode) {
		this.name = name;
		this.code = code;
		this.parentcode = parentcode;
	}
	public China() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getParentcode() {
		if (null==parentcode) {
			parentcode = "0";
		}
		return parentcode;
	}
	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}
//	public void setChinas(List<China> chinas) {
//		this.chinas = chinas;
//	}
//	public List<China> getChinas() {
//		return chinas;
//	}
	@Override
	public String toString() {
		return "China [name=" + name + ", code=" + code + ", parentcode="
				+ parentcode + "]";
	}
	
}
