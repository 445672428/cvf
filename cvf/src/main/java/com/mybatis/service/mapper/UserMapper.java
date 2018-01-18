package com.mybatis.service.mapper;

import com.mybatis.service.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(String uName);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String uName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}