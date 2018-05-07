package com.frame.service;

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

import com.annotation.SysLogColumn;
import com.base.BaseService;
import com.entities.TUser;
import com.redis.RedisHandler;

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
}
