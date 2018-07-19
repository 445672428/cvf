package com.sql;

public class SqlBean {
	
	private String select;
	private String from;
	private String function;
	private String aggr;
	private String condtion;
	private String where;
	
	private DBSQL dbsql;
	
	public SqlBean(){}
	public String getSql() {
		return this.getSelect() + this.getFrom()+this.getWhere();
	}
	
	
	public String getSelect() {
		return "select "+select;
	}
	public void setSelect(String select) {
		this.select = select;
	}
	public String getFrom() {
		return " from "+from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getAggr() {
		return aggr;
	}
	public void setAggr(String aggr) {
		this.aggr = aggr;
	}
	public String getCondtion() {
		return condtion;
	}
	
	public void setCondtion(String condtion) {
		this.condtion = condtion;
	}
	public DBSQL getDbsql() {
		return dbsql;
	}
	
	public void setDbsql(DBSQL dbsql) {
		this.dbsql = dbsql;
	}
	public String getWhere() {
		return where;
	}
	public void setWhere(String where) {
		this.where = where;
	}
}
