package com.mybatis.mapper;

import com.mybatis.pojo.Role;

public interface RoleMapper {
    int deleteByPrimaryKey(String rId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String rId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}