package com.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.statement.SQLSelect;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.sql.visitor.SQLASTOutputVisitor;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import com.alibaba.druid.util.JdbcUtils;
import com.utils.DBUtils;


/**
 * 当前SQL 对应库
 * @author bobo
 *
 */
public class DBSQL {
	protected static final Logger logger = LoggerFactory.getLogger(DBSQL.class);
	
	private boolean master = false; 
	private String name;
	private String sql;
	private String primary[];
	
	private String cols[] = new String[]{};
	
	private DB db;
	
	private SqlBean sqlBean;
	
	private List<Map<String, Object>> results = new ArrayList<Map<String,Object>>();
	public boolean getMaster(){
		return master;
	}
	public DBSQL(String name,String sql,String primary[],DB db,boolean master){
		this.name = name;
		this.sql = sql;
		this.primary = primary;
		this.db = db;
		this.master = master;
		analysisQueryList();
		queryData();
	}
	
	public void queryData(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DBUtils.getConnection(this.db.getDriver(), this.db.getUrl(), this.db.getUsername(), this.db.getPassword());
			statement = connection.createStatement();
			resultSet = statement.executeQuery(this.sql); 
			while (resultSet.next()) { 
				ResultSetMetaData cols = resultSet.getMetaData();
				int count=cols.getColumnCount();

				Map<String, Object>  m = new HashMap<String, Object>();
				for(int i=0;i<count;i++){
					String col = cols.getColumnName(i+1);
					this.cols[i] = col;
					Object o = resultSet.getObject(col);
					m.put(col, o);
				}
				this.results.add(m);
				
			}
		} catch (Exception e) {
			logger.info(this.db.getDbname()+"链接失败");
		}finally{
			DBUtils.closeConnection(connection, statement,resultSet);
		}
	}
	
	/**
	 * 根据不同数据库解析SQL
	 * @param sql
	 */
	public void analysisQueryList(){
		// 新建 SQL Parser
		SQLStatementParser parser = new  SQLStatementParser(this.sql);
        // 使用Parser解析生成AST，这里SQLStatement就是AST
		SQLSelectStatement statement = (SQLSelectStatement)parser.parseSelect();
        // 使用visitor来访问AST
        SQLSelect sQLSelect = statement.getSelect();
        SQLSelectQueryBlock queryBlock = (SQLSelectQueryBlock)sQLSelect.getQuery(); 
        SchemaStatVisitor visitor = new SchemaStatVisitor();
        statement.accept(visitor);
        StringBuffer out = new StringBuffer() ;  
        SQLASTOutputVisitor sqlastOutputVisitor = SQLUtils.createFormatOutputVisitor(out , null , JdbcUtils.SYBASE) ;
        out.delete(0, out.length()) ;  
        
        for (SQLSelectItem sqlSelectItem : queryBlock.getSelectList()) {  
            if(out.length()>1){  
                out.append(",") ;  
            }  
            sqlSelectItem.accept(sqlastOutputVisitor);  
        }  
        SqlBean sqlBean = new SqlBean();
        
        String col = StringUtils.join(this.primary,",");
        sqlBean.setSelect(col);
        
        
        out.delete(0, out.length()) ;
        queryBlock.getFrom().accept(sqlastOutputVisitor) ;  
        sqlBean.setFrom(out.toString());
        
        out.delete(0, out.length()) ;  
        queryBlock.getWhere().accept(sqlastOutputVisitor) ;   
        sqlBean.setWhere(out.toString());
       this.setSqlBean(sqlBean);
        
	}
	private void setSqlBean(SqlBean sqlBean) {
		this.sqlBean = sqlBean;
	}
	public SqlBean getSqlBean(){
		return sqlBean;
		
	}
	
	public DBSQL(String name, String sql,DB db) {
		this.name = name;
		this.sql = sql;
		this.setDb(db);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String[] getPrimary() {
		return primary;
	}
	public void setPrimary(String primary[]) {
		this.primary = primary;
	}
	public List<Map<String, Object>> getResults() {
		return results;
	}
	public DB getDb() {
		return db;
	}
	public void setDb(DB db) {
		this.db = db;
	}
}
