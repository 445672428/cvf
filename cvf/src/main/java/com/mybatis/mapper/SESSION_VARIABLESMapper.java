package com.mybatis.mapper;

import com.mybatis.pojo.SESSION_VARIABLES;
import com.mybatis.pojo.SESSION_VARIABLESExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SESSION_VARIABLESMapper {
    int countByExample(SESSION_VARIABLESExample example);

    int deleteByExample(SESSION_VARIABLESExample example);

    int insert(SESSION_VARIABLES record);

    int insertSelective(SESSION_VARIABLES record);

    List<SESSION_VARIABLES> selectByExample(SESSION_VARIABLESExample example);

    int updateByExampleSelective(@Param("record") SESSION_VARIABLES record, @Param("example") SESSION_VARIABLESExample example);

    int updateByExample(@Param("record") SESSION_VARIABLES record, @Param("example") SESSION_VARIABLESExample example);
}