package com.mybatis.mapper;

import com.mybatis.pojo.Button;

public interface ButtonMapper {
    int deleteByPrimaryKey(String btnId);

    int insert(Button record);

    int insertSelective(Button record);

    Button selectByPrimaryKey(String btnId);

    int updateByPrimaryKeySelective(Button record);

    int updateByPrimaryKey(Button record);
}