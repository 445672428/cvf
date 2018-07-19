package com.sql.eprc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.sql.DB;
import com.sql.DBSQL;
import com.sql.SqlField;
import com.utils.DBUtils;


/**
 * 行
 * @author bobo
 *
 */
public class Row {
	private static final int LIMIT = 1000;
	
	private List<DBSQL> list = new ArrayList<DBSQL>();
	private List<Map<String, Object>> results;
	private int[][] rowResults;
	
	private Row(){}
	
	public Row(List<DBSQL> list,DB db) throws Exception{
		this();
		if (list==null|| list.size()<2) {
			throw new Exception("必须要有对比项");
		}
		this.list = list;
		compare();
	}
	public void compare(){
		this.rowResults = new int[this.list.size()-1][0]; 
		for(int i = 0; i < this.list.size()-1; i ++){
			DBSQL preDbsql = this.list.get(i);
			DBSQL afterDbsql = this.list.get(i+1);
			int[] r = compare(preDbsql.getResults(),afterDbsql.getResults());
			rowResults[i] = r;
		}
		
		for(int i = 0; i <rowResults.length; i++){
			DBSQL e = this.list.get(i);
			boolean is = e.getMaster();
			
			int[] rs = rowResults[i];
			int total = 0;
			for(int j = 0; j < rs.length; j++){
				total += rs[j];
			}
			if (total != rs.length) {
				DBSQL preDbsql = this.list.get(i);
				DBSQL afterDbsql = this.list.get(i+1);
				compare(preDbsql,afterDbsql);
			}
		}
	}
	
	public String[] getMaxLength(Set<String> s){
		String[] size = new String[s.size()];
		int i = 0;
		for(String key : s){
			size[i] = key;
		}
		return size;
	}
	public int[] compare(List<Map<String, Object>> l1 ,List<Map<String, Object>> l2){
		List<Map<String, Object>> l = getMaxLength( l1 , l2);
		int[] result = new int[l.size()];
		for(Map<String, Object> m1 : l1){
			int i = 0;
			for(Map<String, Object> m2 : l2){
				if (m1.equals(m2)) {
					result[i] = 1;
					continue;
				}
				i ++;
			}
		}
		return result;
	}
	
	public void compare(DBSQL master,DBSQL slave){
		DB db = slave.getDb();
		String sql = slave.getSqlBean().getSql();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		Connection masterCon = null;
		PreparedStatement masterStat = null;
		
		try {
			masterCon = DBUtils.getConnection(master.getDb().getDriver(),master.getDb().getUrl(), master.getDb().getUsername(), master.getDb().getPassword());
			
			connection = DBUtils.getConnection(db.getDriver(),db.getUrl(), db.getUsername(), db.getPassword());
			statement = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			statement.setFetchSize(LIMIT);
			resultSet = statement.executeQuery(); 
			
			List<SqlField> fields = new ArrayList<SqlField>();
			String values = "";
			for(int i = 0; i < master.getPrimary().length; i ++){
				String name = master.getPrimary()[i];
				String mold = "varchar(20) not null";
				SqlField field = new SqlField(name, mold);
				fields.add(field);
				if (i == (master.getPrimary().length-1)) {
					values += "?";
				}else{
					values += "?,";
				}
			}
			TemporaryTable table = new TemporaryTable(fields);
			String insert = "insert ignore into "+ table.getTableName() +"("+StringUtils.join(slave.getPrimary(), ",")+") values ("+values+")";
			masterStat = masterCon.prepareStatement(insert); 
			
			table.createTempTable(masterCon);
			
			//查询 主键类型
			int index = 0;
			while (resultSet.next()) {
				for(int i = 0; i < fields.size(); i ++){
					String name = fields.get(i).getName();
					String type = fields.get(i).getType();
					Object o = resultSet.getObject(name);
					if ("char,varchar".indexOf(type.toLowerCase()) > -1) {
						masterStat.setString(i+1, (String)o);
					}else{
						masterStat.setInt(i+1, (Integer)o);
					}
				}
				
				masterStat.addBatch(); 
				if((index+1) % LIMIT==0){
					masterStat.executeBatch();    //执行批处理 
	                masterStat.clearBatch();        //清理批处理 
                }
				index ++;
			}
            if(index % LIMIT != 0){
            	masterStat.executeBatch();
            	masterStat.clearBatch();
            }
            //进行数据差异对比
            
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection(connection, statement, resultSet);
			DBUtils.closeConnection(masterCon, masterStat, null);
		}
		
	}
	
	
	public DBSQL getEq(DBSQL pre,DBSQL after,DBSQL max){
		return max.equals(pre) ? after : pre;
	}
	
	public DBSQL getMaxLength(DBSQL pre,DBSQL after){
		return (pre.getResults().size() - after.getResults().size())>0 ? pre : after;
	}
	
	public List<Map<String, Object>> getMaxLength(List<Map<String, Object>> l1 ,List<Map<String, Object>> l2){
		return (l1.size() - l2.size())>0 ? l1 : l2;
	}
	
	public List<Map<String, Object>> getResults() {
		return results;
	}
	public void setResults(List<Map<String, Object>> results) {
		this.results = results;
	}
	public List<DBSQL> getList() {
		return list;
	}

	public void setList(List<DBSQL> list) {
		this.list = list;
	}

	public static int[][] create_Matrix(int row_number,int column_number ) {
		int matrixA[][] = new int[row_number][column_number];
		for (int i = 0; i <= row_number - 1; i++) {
			for (int j = 0; j <= column_number - 1; j++) {
				matrixA[i][j] = 0;
			}
		}
		return matrixA;
	}
}
