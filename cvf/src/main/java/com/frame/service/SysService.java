package com.frame.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import scala.util.parsing.combinator.testing.Str;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.annotation.Column;
import com.annotation.SysLogColumn;
import com.base.BaseService;
import com.base.connection.ConnectionHolderDefault;
import com.base.intface.ConnectionHolder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.hibernate.pojo.Syslog;
import com.pojo.PageBean;
import com.sql.DB;
import com.utils.CacheUtils;

@Service
public class SysService extends BaseService{
	
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	
    @Transactional
    @SysLogColumn(operationName="插入一个数据库信息")
	public void insertOneDBConnection(DB db){
		String sql = "insert into dbs(id,user,dbname,type,ip,port,url,username,password,driver,commont)values ('"+db.getId()+"','"+db.getUser()+"','"+db.getDbname()+"','"+db.getType()+"','"+db.getIp()+"',"+db.getPort()+",'"+db.getUrl()+"','"+db.getUsername()+"','"+db.getPassword()+"','"+db.getDriver()+"','"+db.getCommont()+"')";
		mysqlJdbcTemplate.execute(sql);
	}
    @Transactional
    @SysLogColumn(operationName="更新当前数据库信息")
	public int updateOneDBConnection(DB db) {
		String sql = "update dbs set dbname='"+db.getDbname()+"',type='"+db.getType()+"',ip='"+db.getIp()+"',port='"+db.getPort()+"',url='"+db.getUrl()+"',username='"+db.getUsername()+"',password='"+db.getPassword()+"',driver='"+db.getDriver()+"',commont='"+db.getCommont()+"' where id = '"+db.getId()+"'";
		return mysqlJdbcTemplate.update(sql);
	}
	
//	@Autowired
//	private HibernateTemplate hibernateTemplate;
	
	public void name() {
		String uuid1 = UUID.randomUUID().toString().replaceAll("-", "");
		String uuid2 = UUID.randomUUID().toString().replaceAll("-", "");
		String uuid = uuid1 + uuid2;
		Syslog bean = new Syslog(uuid);
		bean.setMessages("hahah");
		bean.setLogtype("1");
		Timestamp time = new Timestamp(12324234);
		bean.setOperatedate(time);
		bean.setUserid("123456");
		bean.setUserip("1.1.1.1");
		bean.setUsername("bobo");
//		Serializable syslog = hibernateTemplate.save(bean);
	}
	@SysLogColumn(operationName="查询当前用户所属数据库")
	public List<Map<String, Object>> queryAllDbs(String user) {
		String sql = "select id,user,dbname,type,ip,port,url,username,password,commont,driver from dbs where user = '"+user+"'";
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		return list;
	}
	@SysLogColumn(operationName="查询所有数据库")
	public List<DB> queryAllDbs() {
		String sql = "select id,user,dbname,type,ip,port,url,username,password,commont,driver from dbs";
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		List<DB> dbs = objectMapper.convertValue(list, new TypeReference<List<DB>>(){});
		return dbs;
	}
	
	
	@SysLogColumn(operationName="更新数据库连接信息")
	@Transactional
	public int updateOneDBConnection(String col,String value, String id) {
		String sql = "update dbs set "+col+"='"+value+"'where id = '"+id+"'";
		return mysqlJdbcTemplate.update(sql);
	}
	@SysLogColumn(operationName="查询当前表总数量")
	public int querySchema(){
		String sql = "select count(*) from information_schema.tables";
		int total = mysqlJdbcTemplate.queryForObject(sql, Integer.class);
		return total;
	}
	@SysLogColumn(operationName="分页查询查询当前库所有表信息")
	public List<Map<String, Object>> queryByDBAllTables(String dbname,Integer limit,Integer offset,String order,String search,int total) {
		StringBuilder builder = new StringBuilder("select TABLE_SCHEMA,TABLE_NAME,TABLE_TYPE,ROW_FORMAT,TABLE_ROWS,DATA_LENGTH,MAX_DATA_LENGTH,INDEX_LENGTH,AUTO_INCREMENT,CREATE_TIME,UPDATE_TIME,CHECK_TIME,TABLE_COLLATION,CREATE_OPTIONS,TABLE_COMMENT from information_schema.tables");
		
		if (!"".equals(search)) {
			builder.append(" where TABLE_NAME like '");
			builder.append(search);
			builder.append("%'");
		}
		builder.append(" limit ");
		builder.append(offset);
		builder.append(",");
		builder.append(limit);
		logger.info(builder.toString());
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(builder.toString());
		return list;
	}
	@SysLogColumn(operationName="查询对应表字段信息")
	public JSONArray querySelectOneTable(String dbname, String tableName,String schema) {
		List<Map<String, Object>> list = this.querySelectByOneTable(tableName, schema);
		JSONArray array = new JSONArray();
		for(Map<String, Object> map: list){
			JSONObject o = new JSONObject();
			o.put("xh", map.get("ORDINAL_POSITION"));
			o.put("filed", map.get("COLUMN_NAME"));
			o.put("datatype", map.get("COLUMN_TYPE"));
			o.put("type", map.get("DATA_TYPE"));
			o.put("isnull", map.get("IS_NULLABLE"));
			o.put("defaultValue", map.get("COLUMN_DEFAULT"));
			o.put("isIndex", map.get("COLUMN_KEY"));
			o.put("chartset", map.get("COLLATION_NAME"));
			o.put("commont", map.get("COLUMN_COMMENT"));
			array.add(o);
		}
		return array;
	}
	@SysLogColumn(operationName="查询当前库当前表字段信息")
	public List<Map<String, Object>> querySelectByOneTable(String tableName,String repertory) {
		String sql = "select TABLE_SCHEMA,TABLE_NAME,COLUMN_NAME,COLLATION_NAME,ORDINAL_POSITION,COLUMN_DEFAULT,IS_NULLABLE,DATA_TYPE,CHARACTER_MAXIMUM_LENGTH,CHARACTER_OCTET_LENGTH,CHARACTER_SET_NAME,COLLATION_NAME,COLUMN_TYPE,COLUMN_KEY,`PRIVILEGES`,COLUMN_COMMENT from information_schema.COLUMNS where table_name ='"+tableName+"' and table_schema = '"+repertory+"'";
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		return list;
	}
	//and table_type='base table'
	@SysLogColumn(operationName="查询所有表信息")
	public void querySelectByOneRepertory(){
		String sql = "select TABLE_SCHEMA,TABLE_NAME,TABLE_TYPE,ROW_FORMAT,TABLE_ROWS,DATA_LENGTH,MAX_DATA_LENGTH,INDEX_LENGTH,AUTO_INCREMENT,CREATE_TIME,UPDATE_TIME,CHECK_TIME,TABLE_COLLATION,CREATE_OPTIONS,TABLE_COMMENT from information_schema.tables";
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
	}
	@SysLogColumn(operationName="查询表是否在当前库")
	public int queryIsInDB(String tableName, String dbName) {
		DB db = (DB)CacheUtils.get(dbName);
		ConnectionHolder holder = new ConnectionHolderDefault();
		return holder.queryForInt(db, "select count(*) from information_schema.tables where TABLE_NAME ='"+tableName+"'");
	}
}
