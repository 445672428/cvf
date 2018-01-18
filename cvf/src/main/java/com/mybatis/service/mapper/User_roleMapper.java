package com.mybatis.service.mapper;

import com.mybatis.service.pojo.User_role;
import com.mybatis.service.pojo.User_roleKey;

public interface User_roleMapper {
    int deleteByPrimaryKey(User_roleKey key);

    int insert(User_role record);

    int insertSelective(User_role record);

    User_role selectByPrimaryKey(User_roleKey key);

    int updateByPrimaryKeySelective(User_role record);

    int updateByPrimaryKey(User_role record);
}