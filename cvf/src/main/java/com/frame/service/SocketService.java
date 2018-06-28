package com.frame.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.entities.Friends;
import com.entities.TAdmin;
@Service
public class SocketService {
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	/**
	 * 查询对应的好友表
	 * @param user
	 * @return
	 */
	public Map<String, List<Friends>> findMyAllFriends(TAdmin user) {
		String sql = "select id,group_name from t_person_friends_group where user_id = 1 ";
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		Map<String, List<Friends>> dataMap = new LinkedHashMap<String, List<Friends>>();
		for(Map<String, Object> map : list){
			String groupName = (String)map.get("group_name");
			Integer id = (Integer)map.get("id");
			List<Friends> friends = null;
			if (dataMap.get(groupName)!=null) {
				friends = dataMap.get(groupName);
				Friends friend = new Friends();
				friends.add(friend);
			}else{
				friends = new ArrayList<Friends>();
				Friends friend = new Friends();
				friends.add(friend);
			}
			dataMap.put(groupName, friends);
		}
		return dataMap;
	}
}
