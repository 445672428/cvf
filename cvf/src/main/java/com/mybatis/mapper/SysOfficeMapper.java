package com.mybatis.mapper;

import com.mybatis.pojo.SysOffice;

public interface SysOfficeMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysOffice record);

    int insertSelective(SysOffice record);

    SysOffice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysOffice record);

    int updateByPrimaryKey(SysOffice record);
}