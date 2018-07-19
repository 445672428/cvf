package com.base.intface;

import java.util.List;
import java.util.Map;

import com.sql.DB;

public interface ConnectionHolder {
	public List<Map<String, Object>> query(DB db,String sql);
	
	public int update(DB db,String sql);
	
	public boolean delete(DB db,String sql);
	
	public void save(DB db,String sql);
	
	public boolean execute(DB db,String sql);

	public int queryForInt(DB db,String sql);
	
}
