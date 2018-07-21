package com.base.intface;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sql.DB;

public interface ConnectionHolder {
	static Logger logger = LoggerFactory.getLogger(ConnectionHolder.class);
	public List<Map<String, Object>> query(DB db,String sql);
	
	public int update(DB db,String sql);
	
	public boolean delete(DB db,String sql);
	
	public void save(DB db,String sql);
	
	public boolean execute(DB db,String sql);

	public int queryForInt(DB db,String sql);
	
}
