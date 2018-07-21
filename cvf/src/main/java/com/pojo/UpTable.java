package com.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UpTable implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2637160169628872867L;
	private String dbName;
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<UpTable.Data> getDatas() {
		return datas;
	}
	public void setDatas(List<UpTable.Data> datas) {
		this.datas = datas;
	}
	public UpTable(){}
	private String tableName;
	List<UpTable.Data> datas = new ArrayList<UpTable.Data>();
    public static class Data{
    	public Data(){}
        public String getChartset() {
			return chartset;
		}
		public void setChartset(String chartset) {
			this.chartset = chartset;
		}
		public String getCommont() {
			return commont;
		}
		public void setCommont(String commont) {
			this.commont = commont;
		}
		public String getDatatype() {
			return datatype;
		}
		public void setDatatype(String datatype) {
			this.datatype = datatype;
		}
		public String getDefaultValue() {
			return defaultValue;
		}
		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}
		public String getFiled() {
			return filed;
		}
		public void setFiled(String filed) {
			this.filed = filed;
		}
		public String getIsIndex() {
			return isIndex;
		}
		public void setIsIndex(String isIndex) {
			this.isIndex = isIndex;
		}
		public String getIsnull() {
			return isnull;
		}
		public void setIsnull(String isnull) {
			this.isnull = isnull;
		}
		public Boolean getState() {
			return state;
		}
		public void setState(Boolean state) {
			this.state = state;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Integer getXh() {
			return xh;
		}
		public void setXh(Integer xh) {
			this.xh = xh;
		}
        private String chartset;//字符集
        private String commont;//概述
        private String datatype;//类型
		private String defaultValue;//默认值
        private String filed;//字段名
        private String isIndex;//索引或者主键
        private String isnull;//是否为空
        private Boolean state;//
        private String type;//
        private Integer xh;//序号
    }
}
