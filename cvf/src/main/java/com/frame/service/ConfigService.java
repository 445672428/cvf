package com.frame.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.base.BaseService;

@Service
public class ConfigService extends BaseService{
	@Value("${img.src1}")
	public String IMG_SRC1;
	@Value("${img.src2}")
	public String IMG_SRC2;
	@Value("${img.src3}")
	public String IMG_SRC3;
	@Value("${img.src4}")
	public String IMG_SRC4;
	
	
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	
	
	public JSONArray queryChinaCode(String parentCode) {
		if (null==parentCode) {
			parentCode = "0";
		}
		String sql = "select name,code,parentcode from china where parentcode = '"+parentCode+"'";
		logger.info(sql);
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		JSONArray array = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> china = list.get(i);
			JSONObject object = new JSONObject();
			object.put("id", china.get("code"));
			object.put("pId", china.get("parentcode"));
			object.put("name", china.get("name"));
			if (StringUtils.trim(parentCode).length()!=6) {
				object.put("isParent", true);
			}else{
				object.put("isParent", false);
			}
			array.add(object);
		}
		return array;
	}
}
