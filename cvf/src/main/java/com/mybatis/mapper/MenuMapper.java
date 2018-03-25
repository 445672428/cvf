package com.mybatis.mapper;

import com.mybatis.pojo.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(String mnId);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String mnId);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}