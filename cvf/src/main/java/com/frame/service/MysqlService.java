package com.frame.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
@Service("mysqlService")
public class MysqlService {
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	/**
	 * 查询mysql 库所有引擎
	 */
	public List<Map<String, Object>> engineSql() {
		String sql = "select ENGINE,SUPPORT,COMMENT,TRANSACTIONS,XA,SAVEPOINTS from INFORMATION_SCHEMA.ENGINES";
		return mysqlJdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查询mysql 库所有字段和对应表
	 */
	public List<Map<String, Object>> columnSqlContainSys() {
		String sql = "select * from INFORMATION_SCHEMA.COLUMNS"; 
		return mysqlJdbcTemplate.queryForList(sql);
	}
	/**
	 * 查询mysql 库所有字段和对应表
	 */
	public List<Map<String, Object>> columnSqlContainSysALL() {
		String sql = "select * from INFORMATION_SCHEMA.KEY_COLUMN_USAGE"; 
		return mysqlJdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查询mysql 库支持字符集
	 */
	public List<Map<String, Object>> chartsetSupportSql() {
		String sql = "select * from INFORMATION_SCHEMA.CHARACTER_SETS"; 
		return mysqlJdbcTemplate.queryForList(sql);
	}

	/**
	 * 查询mysql 查询每个表支持新型
	 */
	public List<Map<String, Object>> tableInfoSupportSql() {
		String sql = "select * from INFORMATION_SCHEMA.PARTITIONS"; 
		return mysqlJdbcTemplate.queryForList(sql);
	}
	/**
	 * 查询mysql 查询表的主键和唯一建
	 */
	public List<Map<String, Object>> tablePrimaryAndPKSupportSql() {
		String sql = "select * from INFORMATION_SCHEMA.STATISTICS"; 
		return mysqlJdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查询mysql 查询表详细情况
	 */
	public List<Map<String, Object>> tableDeatilInfoSupportSql() {
		String sql = "select * from INFORMATION_SCHEMA.TABLES"; 
		return mysqlJdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查询mysql 对应库对应表的主键和唯一建
	 */
	public List<Map<String, Object>> dataBDTableToPKSupportSql() {
		String sql = "select * from INFORMATION_SCHEMA.TABLE_CONSTRAINTS"; 
		return mysqlJdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查询mysql 当前用户具有的操作权限
	 */
	public List<Map<String, Object>> handlerPowerSupportSql() {
		String sql = "select * from INFORMATION_SCHEMA.USER_PRIVILEGES"; 
		return mysqlJdbcTemplate.queryForList(sql);
	}
	
	/**
	 * 查询mysql 查询视图
	 */
	public List<Map<String, Object>> viewsSupportSql() {
		String sql = "select * from INFORMATION_SCHEMA.VIEWS"; 
		return mysqlJdbcTemplate.queryForList(sql);
	}
}
