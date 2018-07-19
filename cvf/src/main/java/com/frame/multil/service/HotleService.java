package com.frame.multil.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.base.BaseService;
import com.frame.service.RedisService;
import com.multil.datasource.DynamicDataSource;
import com.pojo.FileInfo;
import com.pojo.PageBean;

import contant.Contant;

@Service
public class HotleService {
	@Qualifier("multilJdbcTemplate")
	@Autowired
	private JdbcTemplate multilJdbcTemplate;

	@Autowired
	private DynamicDataSource mutildataSource;
	@Autowired
	private RedisService redisService;
	
	public PageBean queryHotleMsg(int pageSize,int start) {
		PageBean pageBean = new PageBean();
		int total = 0;
		if (null!=redisService.get(Contant.HOTLE_REDIS_COUNT)) {
			total = Integer.parseInt(redisService.get(Contant.HOTLE_REDIS_COUNT));
		}else{
			String totalSql = "select count(*) from hotle";
			total = multilJdbcTemplate.queryForInt(totalSql);
			redisService.set(Contant.HOTLE_REDIS_COUNT, String.valueOf(total));
		}
		pageBean.setPage(start);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalCount(total);
		String sql = "select name,birthday,gender,Address,mobile,nation,education,company,id from hotle limit "+pageBean.getStart()+","+pageBean.getPageSize()+"";
		List<Map<String, Object>> list = multilJdbcTemplate.queryForList(sql);
		pageBean.setList(list);
		return pageBean;
	}

}
