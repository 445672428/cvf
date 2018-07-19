package com.sql.eprc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.sql.SqlField;
import com.utils.DBUtils;

/**
 * 创建一个临时表
 * @author bobo
 *
 */
public class TemporaryTable {
	private String tableName = String.valueOf(System.currentTimeMillis());
	
	//需要创建表字段
	private List<SqlField> fields = new ArrayList<SqlField>();
	
	
	public void createTempTable(Connection connection) throws Exception{
		String sql = "CREATE TABLE `"+this.tableName+"` ("+StringUtils.join(this.fields, ",")+") ENGINE=MyISAM DEFAULT CHARSET=utf8";
		Statement statement = null;
		statement = connection.createStatement();
		statement.execute(sql);
		DBUtils.closeConnection(null, statement);
	}
	
	public void loadSourceDataToDest(Connection connection,String cond) throws SQLException{
		String cols = StringUtils.join(this.fields, ",");
		String sql =  "(select "+cols+" )" + cond;
		PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
		preparedStatement.setFetchSize(4000);
		preparedStatement.setFetchDirection(ResultSet.FETCH_REVERSE);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()){
			for(int i = 0; i < this.fields.size() ; i++){
				Object o = resultSet.getObject(this.fields.get(i).getName());
				
			}
			String insertSql = "insert ignore into "+ this.tableName +"() values ()";
		}
	}
	
	public void getCompareDataToDest(Connection connection,String cond) throws SQLException{
		String cxt = StringUtils.join(this.fields, "+");
		String cols = StringUtils.join(this.fields, ",");
		String sql = "select "+cols+"  from "+this.tableName +" where "+ cxt +"not in (select "+cols+" )" + cond;
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
		preparedStatement.setFetchSize(4000);
		preparedStatement.setFetchDirection(ResultSet.FETCH_REVERSE);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
//		while(resultSet.next()){
//			Map<String, Object> m = new HashMap<String, Object>();
//			for(int i = 0; i < this.primary.length; i ++){
//				Object o = resultSet.getObject(this.primary[i]);
//				m.put(this.primary[i], o);
//			}
//			list.add(m);
//		}
		DBUtils.closeConnection(null, preparedStatement,resultSet);
	}
	
	
	public TemporaryTable dropThisTable(Connection connection) throws Exception{
		String clean =  "truncate table" + this.tableName;
		String sql = "drop TABLE `"+this.tableName+"`";
		Statement statement = null;
		statement = connection.createStatement();
		statement.execute(clean);
		statement.execute(sql);
		DBUtils.closeConnection(null, statement);
		return this;
	}
	
	
	public TemporaryTable(List<SqlField> fields) throws Exception{
		if (fields==null || fields.size()==0) {
			throw new Exception("创建表至少要用一个字段");
		}
		this.fields = fields;
	}
	public String getTableName() {
		return tableName;
	}
}
