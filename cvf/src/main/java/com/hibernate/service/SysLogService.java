package com.hibernate.service;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.hibernate.pojo.Syslog;

@Service
public class SysLogService extends HBaseService<Syslog> {
	public void insertmysave() {
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
		save(bean);
	}
}
