package com.templet.word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.templet.model.Form;
import com.templet.model.StoreRoom;
import com.templet.model.Table;

public class DBDataDictionary {
	
	
	/**
	 * sybase获取当前库表
	 * @param jdbcTemplate
	 * @return
	 */
	public List<String> queryConnectionInfo(JdbcTemplate jdbcTemplate) {
		String sql = "SELECT name from sysobjects WHERE type ='U'";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		List<String> tables = new ArrayList<String>();
		for(Map<String, Object> m : list){
			String table = (String)m.get("name");
			if (StringUtils.isEmpty(table) ) {
				continue;
			}
			tables.add(table);
		}
		return tables;
	}
	
	/**
	 * 获取表的字段
	 */
	public List<Map<String, Object>> queryPKByDB(JdbcTemplate jdbcTemplate,String tableName){
		String sql = " select   indid, keycnt, name,object_name(id) as tabname from sysindexes where  indid >=1 and status&2048=2048 ";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list;
	}
	
	public List<Form> queryTableInfo(JdbcTemplate jdbcTemplate,String table){
      String sql = "SELECT sysobjects.name AS tablename ,syscolumns.name as colname,syscolumns.length as colLength,systypes.name as colType,systypes.variable,systypes.allownulls from syscolumns left join sysobjects on syscolumns.id = sysobjects.id and ( sysobjects.type = 'U' OR  sysobjects.type = 'V' ) and sysobjects.name='"+ table+ "' left join systypes on syscolumns.usertype = systypes.usertype where sysobjects.name='"+ table + "' order  by sysobjects.name,syscolumns.name";
      List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
      List<Form> forms = new ArrayList<Form>();
      for(Map<String, Object> m : list){
    	  String tablename = (String)m.get("tablename");//表名
    	  String colname = (String)m.get("colname");//字段名
    	  int colLength = (Integer)m.get("colLength");//字段长度
    	  String colType = (String)m.get("colType");//字段类型
    	  m.get("variable");//是否初始化
    	  m.get("allownulls");//是否为空
    	  String columnDetail = colType+" "+colLength;
    	  Form form = new Form(colname, colType, columnDetail, "", "");
    	  forms.add(form);
      }
      return forms;
	}
	
	
	
	/**
	 * 获取完备数据
	 * @param jdbcTemplate
	 * @param dbName
	 * @return
	 */
	public StoreRoom CreateDBInfOBean(JdbcTemplate jdbcTemplate,String dbName){
		List<String> tables = queryConnectionInfo(jdbcTemplate);
		StoreRoom storeRoom = new StoreRoom(dbName);
		List<Table> list = new ArrayList<Table>();
		for(String table :tables){
			Table t = new Table(table);
			List<Form> forms = queryTableInfo( jdbcTemplate, table);
			t.setForms(forms);
			list.add(t);
		}
		storeRoom.setTables(list);
		return storeRoom;
	}
	
    /**
    * 查询sybase 库所有主键
    */
	public Map<String, Map<String, String>> getDBAllPK(JdbcTemplate jdbcTemplate) {
		Map<String, Map<String, String>> allPkMap = new HashMap<String, Map<String, String>>();
		List<Map<String, Object>> list = queryPKByDB(jdbcTemplate,null);
		for(Map<String, Object> map : list){
			int indid = map.get("indid") == null ? 0 : (Integer) map.get("indid");
			int keycnt = map.get("keycnt") == null ? 0 : (Integer) map.get("keycnt");
			String keyName = StringUtils.trim((String) map.get("name"));// 主键名称
			String tableName = StringUtils.trim((String) map.get("tabname"));// 表名称
			for (int index = 1; index <= keycnt; index++) {
				String sql = "SELECT index_col('"+ tableName+ "',2,"+ index+ ") as pkname from sysindexes WHERE indid=2 AND  id=object_id('"+ tableName + "')";
				List<Map<String, Object>> pkList = jdbcTemplate
						.queryForList(sql);

				if (pkList != null && pkList.size() > 0) {
					Map<String, Object> kyM = pkList.get(0);
					String pkName = (String) kyM.get("pkname");
					if (allPkMap.get(tableName) == null) {
						Map<String, String> mm = new HashMap<String, String>();
						mm.put(pkName, "PK");
						allPkMap.put(tableName, mm);
					} else {
						Map<String, String> mm = allPkMap.get(tableName);
						mm.put(pkName, "PK");
						allPkMap.put(tableName, mm);
					}
				}
			}
		}
		return allPkMap;
	}
}
