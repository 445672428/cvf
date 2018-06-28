package com.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.annotation.SysLogColumn;
import com.mybatis.mapper.SysAppMapper;
import com.mybatis.mapper.SysElementMapper;
import com.mybatis.mapper.SysOrganizeMapper;
import com.mybatis.mapper.SysSourceMapper;
import com.mybatis.mapper.SysUserMapper;
import com.mybatis.pojo.SysApp;
import com.mybatis.pojo.SysElement;
import com.mybatis.pojo.SysOrganize;
import com.mybatis.pojo.SysSource;
import com.mybatis.pojo.SysUser;

@Service
public class MSysPermissionService {
	@Autowired
	private SysOrganizeMapper sysOrganizeMapper;
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired
	private SysSourceMapper sysSourceMapper;
	
	@Autowired
	private SysElementMapper sysElementMapper;
	
	@Autowired
	private SysAppMapper sysAppMapper;
	
	@SysLogColumn(operationName="插入一群组织")
	public void insertMoreOrganize(List<SysOrganize> records){
		for(SysOrganize record:records){
			int flag = insertOneOrganize(record);
		}
	}
	@SysLogColumn(operationName="插入一个组织")
	public int insertOneOrganize(SysOrganize record){
		int flag = sysOrganizeMapper.insert(record);
		return flag;
	}
	
	@SysLogColumn(operationName="插入一个人员")
	public int insertOneUser(SysUser record){
		int flag = sysUserMapper.insert(record);
		return flag;
	}
	
	public List<SysOrganize> getGroupList(){
		List<SysOrganize> list = sysOrganizeMapper.selectAll();
		return list;
	}
	
	@SysLogColumn(operationName="插入一个资源")
	public int insertOneSource(SysSource record) {
		return sysSourceMapper.insert(record);
	}
	@SysLogColumn(operationName="添加元素")
	public int insertOnesysElement(SysElement sysElement) {
		return sysElementMapper.insert(sysElement);
	}
	@SysLogColumn(operationName="添加一个应用功能")
	public int insertOneSysApp(SysApp sysApp) {
		sysAppMapper.insert(sysApp);
		return 0;
	}
}
