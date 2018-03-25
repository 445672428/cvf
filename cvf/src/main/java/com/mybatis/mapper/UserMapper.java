package com.mybatis.mapper;

import com.mybatis.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(String uName);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}