package com.frame.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.hibernate.pojo.Syslog;
import com.mybatis.mapper.ButtonMapper;

@Service
public class SysService {
	@Autowired
	private ButtonMapper buttonMapper;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void name() {
		String uuid1 = UUID.randomUUID().toString().replaceAll("-", "");
		String uuid2 = UUID.randomUUID().toString().replaceAll("-", "");
		String uuid = uuid1 + uuid2;
		Syslog bean = new Syslog(uuid);
		bean.setMessages("hahah");
		bean.setLogtype("1");
		Timestamp time = new Timestamp(12324234);
		bean.setOperatedate(time);
		bean.setUserid("123456");
		bean.setUserip("1.1.1.1");
		bean.setUsername("bobo");
		Serializable syslog = hibernateTemplate.save(bean);
		System.err.println(syslog);
	}
	
	
}
