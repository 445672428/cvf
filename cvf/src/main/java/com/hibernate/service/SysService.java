package com.hibernate.service;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hibernate.service.pojo.Yythd;

@Service("sysService")
public class SysService {
	@Qualifier("hernateSessionFactory")
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSessionFactory() {
		return sessionFactory.getCurrentSession();
	}
	
	public void groupAdd(){
		Yythd yythd = new Yythd();
		yythd.setBm("aadas");
		yythd.setBz("ada");
		yythd.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		getSessionFactory().save(yythd);
        System.out.println(yythd.getId());
    }
	
}
