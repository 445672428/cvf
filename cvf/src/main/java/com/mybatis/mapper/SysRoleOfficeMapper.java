package com.mybatis.mapper;

import com.mybatis.pojo.SysRoleOfficeKey;

public interface SysRoleOfficeMapper {
    int deleteByPrimaryKey(SysRoleOfficeKey key);

    int insert(SysRoleOfficeKey record);

    int insertSelective(SysRoleOfficeKey record);
}