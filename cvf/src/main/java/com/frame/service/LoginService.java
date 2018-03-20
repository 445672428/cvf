package com.frame.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.annotation.SysLogColumn;
import com.base.BaseService;
import com.ctc.wstx.util.StringUtil;
import com.entities.Friends;
import com.entities.TUser;
import com.redis.RedisHandler;
import com.utils.ComUtils;

import contant.Contant;
@Service
public class LoginService extends BaseService{
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	public TUser findUser(String name,String password){
		String sql = "SELECT USERNAME,PASSWORD FROM USER WHERE NAME = '"+name+"' AND PASSWORD = '"+Md5Crypt.apr1Crypt(password)+"'";
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		TUser user = new TUser();
		if (list!=null&&list.size()>0) {
			Map<String, Object> map = list.get(0);
			user.setPassWord(StringUtils.trim((String)map.get("PASSWORD")));
			user.setUserName(StringUtils.trim((String)map.get("USERNAME")));
			RedisHandler redisHandler = new RedisHandler();
			JedisPool jedisPool = redisHandler.getInstance();
			Jedis jedis = jedisPool.getResource();
			jedis.set(Contant.USER_KEY.getBytes(),SerializationUtils.serialize(user));
			return user;
		}
		return null;
	}
	@Transactional
	@SysLogColumn(operationName="保存用户")
	public void saveNewUser(TUser user) {
		String sql = "insert into t_admin (admin_name,password,email,telephone) values ('"+user.getUserName()+"','"+user.getPassWord()+"','"+user.getEmail()+"','"+user.getMobile()+"')";
		mysqlJdbcTemplate.execute(sql);
	}
	  
	
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

	@Transactional
	public JSONObject saveFileName(String userid, String filename, String parentid,Integer level,String uuid) {
		String sql = "insert into filetable (id,userid,filename,level,ishidden,parentid,description,subName,createtime) values (?,?,?,?,?,?,?,?,?)";
		logger.info(sql);
		mysqlJdbcTemplate.update(sql, new Object[]{uuid,userid,filename,level,false,parentid,null,null,ComUtils.getTimestamp()});
		JSONObject object = new JSONObject();
		object.put("id", uuid);
		object.put("userid", userid);
		object.put("filename", filename);
		object.put("level", level);
		object.put("ishidden", false);
		object.put("parentid", parentid);
		return object;
	}

	/**
	 * 查询当前 用户所有目录文件
	 * @param userid
	 * @param parentid
	 * @param level
	 * @return
	 */
	public JSONObject queryFileByUUid(String userid, String parentid,Integer level) {
		if (level==null) {
			level = 0;
		}
		if (parentid==null) {
			parentid = Contant.DEFAULT_USER;
		}
		if (userid==null) {
			userid = Contant.DEFAULT_USER;
		}
		String sql = "select id,userid,filename,level,ishidden,createtime from filetable where userid='"+userid+"' and parentid = '"+parentid+"' and level = "+level+"";
		logger.info(sql);
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		JSONObject object = new JSONObject();
		object.put("list", list);
		return object;
	}
	public TUser findCurUser(String username,String password) {
		String sql = "select admin_name,id from t_admin where admin_name='"+username+"' and password = '"+password+"'";
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		if (list==null||list.size()==0) {
			return null;
		}
		Map<String, Object> map = list.get(0);
		TUser tUser = new TUser();
		tUser.setUserName((String)map.get("admin_name"));
		tUser.setPassWord(password);
		tUser.setMobile("13554502745");
		tUser.setId((Long)map.get("id"));
		return tUser;
	}
	/**
	 * 删除当前文件
	 * @param userid
	 * @param parentid
	 * @param level
	 * @return
	 */
	@Transactional
	public JSONObject deleteFileByUUid(String userid, String parentid,Integer level) {
		String sql = "delete from filetable where ";
		String condition = "";
		List<String> list = new ArrayList<String>();
		list = queryForChilds(parentid,list);
		list.add(parentid);
		System.out.println(list.toString());
		condition = createOrCondition(list,"id");
		sql = sql + condition;
		mysqlJdbcTemplate.execute(sql);
		JSONObject object = new JSONObject();
		object.put("succ", list);
		return object;
	}
	
	
	
	public List<String> queryForChilds(String id,List<String> list) {
		String sql = "SELECT id,userid,filename,level,ishidden,parentid FROM filetable where parentid='"+id+"'";
		List<Map<String, Object>> result = mysqlJdbcTemplate.queryForList(sql);
		if (result!=null&&result.size()>0) {
			for (Map<String, Object> map : result) {
				String _id = StringUtils.trim((String)map.get("id"));
				String _userid = StringUtils.trim((String)map.get("userid"));
				String _name = StringUtils.trim((String)map.get("filename"));
				int _level = (Integer)map.get("level");
				Boolean _is = (Boolean)map.get("ishidden");
				String _parentid = StringUtils.trim((String)map.get("parentid"));
				if (!_is) {
					list.add(_id);
					queryForChilds(_id,list);
				}
			}
		}
		return list;
	}
	@Transactional
	public int updateFileNameById(String id, String name) {
		String sql = "update filetable set filename = '"+name+"' where id = '"+id+"'";
		int count = mysqlJdbcTemplate.update(sql);
		return count;
	}
	
	/**
	 * 查询对应的好友表
	 * @param user
	 * @return
	 */
	public Map<String, List<Friends>> findMyAllFriends(TUser user) {
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
