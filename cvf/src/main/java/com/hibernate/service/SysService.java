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
	/**
	 * 添加用户
	 */
	public void insertUser() {
		
	}
	
	/**
	 * 添加角色
	 */
	public void insertRoleType() {
		
	}
	/**
	 * 增加权限资源
	 */
	public void insertAuthority() {
		
	}
	/**
	 * 增加用户和角色关系
	 */
	public void addUserAndRoleRelation() {
		
	}
	/**
	 * 增加角色和权限之间的关系
	 */
	public void addRoleToAuthorityRelation() {
		
	}
	
	/**
	 * 增加用户组
	 */
	public void addUserGroup() {
		
	}
	/**
	 * 用户组与用户之间的关系
	 */
	public void addUerAndGroupRelation() {
		
	}
	/**
	 * 增加用户组与角色之间的关系
	 */
	public void addUserGroupAndRoleRelation() {
		
	}
	/**
	 * 增加系统菜单
	 */
	public void addSystemMenu() {
		
	}
	/**
	 * 增加权限菜单与权限表之间的关系
	 */
	public void addMenuToAuthorityRelation() {
		
	}
	/**
	 * 增加页面元素与权限表之间关系
	 */
	public void addPageElementToAuthorityRelation() {
		
	}
	/**
	 * 增加文件与权限之间关系
	 */
	public void addfileToAuthorityRelation() {
		
	}
	/**
	 * 增加权限操作
	 */
	public void addAuthorityHandler() {
		
	}
	/**
	 * 功能操作添加
	 */
	public void addFunctionHandler() {
		
	}
	
}

