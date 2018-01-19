package com.frame.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.base.BaseService;
import com.entities.User;
import com.redis.RedisHandler;
import com.utils.ComUtils;
import com.utils.StringUtils;

import contant.Contant;
@Service
public class LoginService extends BaseService{
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	public User findUser(String name,String password){
		String sql = "SELECT USERNAME,PASSWORD FROM USER WHERE NAME = '"+name+"' AND PASSWORD = '"+Md5Crypt.apr1Crypt(password)+"'";
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		User user = new User();
		if (list!=null&&list.size()>0) {
			Map<String, Object> map = list.get(0);
			user.setPassWord(StringUtils.trim(map.get("PASSWORD")));
			user.setUserName(StringUtils.trim(map.get("USERNAME")));
			RedisHandler redisHandler = new RedisHandler();
			JedisPool jedisPool = redisHandler.getInstance();
			Jedis jedis = jedisPool.getResource();
			jedis.set(Contant.USER_KEY.getBytes(),SerializationUtils.serialize(user));
			return user;
		}
		return null;
	}
	@Transactional
	public void saveNewUser(User user) {
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
	public User findCurUser(String username,String password) {
		String sql = "select admin_name,id from t_admin where admin_name='"+username+"' and password = '"+password+"'";
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		if (list==null||list.size()==0) {
			return null;
		}
		Map<String, Object> map = list.get(0);
		User user = new User();
		user.setUserName(StringUtils.trim(map.get("admin_name")));
		user.setId(StringUtils.trim(map.get("id")));
		return user;
	}
	/**
	 * 删除当前文件
	 * @param userid
	 * @param parentid
	 * @param level
	 * @return
	 */
	public JSONObject deleteFileByUUid(String userid, String parentid,Integer level) {
		return null;
	}
}
