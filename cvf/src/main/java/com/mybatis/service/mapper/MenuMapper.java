package com.mybatis.service.mapper;

import com.mybatis.service.pojo.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(String mnId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String mnId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}