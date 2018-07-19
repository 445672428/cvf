package com.sql;


/**
 * 当前主键信息
 * @author bobo
 *
 */
public class SqlField {
	private String name;
	private String mold;
	private String alias;
	
	
	public String getType() {
		if (mold.indexOf("(")>-1) {
			return mold.substring(0, mold.indexOf("("));
		}else{
			return mold.substring(0, mold.indexOf(" "));
		}
		
	}
	
	public SqlField(String name,String mold){
		this.name = name;
		this.mold = mold;
	}
	@Override
	public String toString() {
		return name +  " " + mold;
	}
	public String getAlias() {
		return alias;
	}
	public String getMold() {
		return mold;
	}
	public String getName() {
		return name;
	}
}
