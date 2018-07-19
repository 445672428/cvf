package com.frame.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.annotation.SysLogColumn;
import com.sql.DBSQL;
import com.utils.ExcelParserUtil;

import contant.Contant;

@Service
public class DataDictionaryService {
	
	@Autowired
	@Qualifier("sybaseJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	
	
	@SysLogColumn(operationName="根据Excel文件sql进行源库和目标库数据比对")
	public void compareSourceDBToDestDB(MultipartFile  uploadExcels) {
		List<String> sheetNames = null;
		try {
			sheetNames = ExcelParserUtil.getSheetNames(Contant.TMP_DIR+uploadExcels.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}

        for(String sheetName :sheetNames){
            //2.读取excel文件---表头是否符合要求
            ExcelParserUtil parser = new ExcelParserUtil(Contant.TMP_DIR+uploadExcels.getOriginalFilename(), sheetName);
            parser.setFirstRow(parser.getStartRow());
            parser.setLastRow(parser.getEndRow());
            List<Map<String,Object>> excels = parser.getSheetData();
            
            for(Map<String,Object> map :excels){
            	map.get("SQL");
            	map.get("name");
            	
            }
            
        }
        
        
	}
	
	public List<Map<String, Object>> queryCurrentResult(String sql,String origin){
		Map<String, JdbcTemplate> m = loadJdbcTemplateMap();
		JdbcTemplate jdbcTemplate = m.get(origin);
		return jdbcTemplate.queryForList(sql);
	}
	
	public Map<String, JdbcTemplate> loadJdbcTemplateMap(){
		Map<String, JdbcTemplate> m = new HashMap<String, JdbcTemplate>();
		
		return m;
	}
}
