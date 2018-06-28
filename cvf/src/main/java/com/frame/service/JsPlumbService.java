package com.frame.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.base.BaseService;
import com.utils.BigDecimalUtils;

@Service
public class JsPlumbService extends BaseService{
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	/**
	 * 查询所有高铁站
	 * @return
	 */
	public JSONArray queryWelcomeJsPlumb() {
		String sql = "select name,code,west,east,south,north from region_station";
		List<Map<String, Object>> results = mysqlJdbcTemplate.queryForList(sql);
		JSONArray array = new JSONArray();
		for (Map<String, Object> m : results) {
			String name = (String)m.get("name");
			String code = (String)m.get("code");
			Double w = (Double)m.get("west");
			Double e = (Double)m.get("east");
			
			Double s = (Double)m.get("south");
			Double n = (Double)m.get("north");
			
			double x = BigDecimalUtils.add(w, e);
			double y = BigDecimalUtils.add(s, n);
			
			x = x / 2;
			y = y / 2;
			JSONObject obj = new JSONObject();
			obj.put("name", name);
			obj.put("code", code);
			obj.put("x", x);
			obj.put("y", y);
			array.add(obj);
		}
		return array;
	}
}
