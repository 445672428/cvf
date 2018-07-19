package com.frame.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.annotation.SysLogColumn;
import com.base.BaseService;
import com.pojo.TAdmin;
import com.utils.TimeUtils;
@Service
public class LoginService extends BaseService{
	
	//@Autowired
	//private RedisClusterClient redisClusterClient;
	@Autowired
	private RedisCacheUtil<TAdmin> redisCache;
	
	
	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlJdbcTemplate;
	@Transactional
	@SysLogColumn(operationName="保存用户")
	public void saveNewUser(TAdmin user) {
		String sql = "insert into t_admin (admin_name,password,email,telephone) values ('"+user.getAdmin_name()+"','"+user.getPassWord()+"','"+user.getEmail()+"','"+user.getTelephone()+"')";
		mysqlJdbcTemplate.execute(sql);
	}
	public TAdmin findCurUser(String username,String password,String ip) {
		String sql = "select admin_name,login_count,id from t_admin where admin_name='"+username+"' and password = '"+password+"'";
		logger.info(sql);
		List<Map<String, Object>> list = mysqlJdbcTemplate.queryForList(sql);
		if (list==null||list.size()==0) {
			return null;
		}
		
		Map<String, Object> map = list.get(0);
		String time = TimeUtils.getCurrentDateStringAll();
		Timestamp timestamp = Timestamp.valueOf(time);
		Integer login_count = map.get("login_count")==null?0:(Integer)map.get("login_count");
		login_count += 1;
		String update = "update t_admin set last_login_ip = '"+ip+"' , last_login_time = '"+timestamp+"' , login_count = "+login_count+" where id = "+map.get("id");
		logger.info(update);
		mysqlJdbcTemplate.update(update);
		
		TAdmin tUser = new TAdmin();
		String name = (String)map.get("admin_name");
		tUser.setAdmin_name(name);
		tUser.setPassWord(password);
		tUser.setTelephone("13554502745");
		tUser.setId((Long)map.get("id"));
		tUser.setLast_login_ip(ip);
		tUser.setLast_login_time(timestamp);
		tUser.setLogin_count(login_count);
		
		//redisCache.setCacheObject(name, tUser);
	//	redisClusterClient.put("13554502745", tUser);
//		RedisHandler redisHandler = new RedisHandler();
//		JedisPool jedisPool = redisHandler.getInstance();
//		Jedis jedis = jedisPool.getResource();
//		jedis.set(Contant.USER_KEY.getBytes(),SerializationUtils.serialize(tUser));
		
		return tUser;
	}
	
	@SysLogColumn(operationName="实时检查用户名是否存在")
	public boolean checkUserName(String name) {
		String sql = "select count(*) from t_admin where admin_name='"+name+"' limit 1";
		Integer n = mysqlJdbcTemplate.queryForObject(sql, Integer.class);
		return n!=0;
	}
}
