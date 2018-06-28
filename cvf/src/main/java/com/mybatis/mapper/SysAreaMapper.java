package com.mybatis.mapper;

import com.mybatis.pojo.SysArea;

public interface SysAreaMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysArea record);

    int insertSelective(SysArea record);

    SysArea selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysArea record);

    int updateByPrimaryKey(SysArea record);
}