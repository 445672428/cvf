package com.mybatis.mapper;

import com.mybatis.pojo.User_role;
import com.mybatis.pojo.User_roleKey;

public interface User_roleMapper {
    int deleteByPrimaryKey(User_roleKey key);

    int insert(User_role record);

    int insertSelective(User_role record);

    User_role selectByPrimaryKey(User_roleKey key);

    int updateByPrimaryKeySelective(User_role record);

    int updateByPrimaryKey(User_role record);
}