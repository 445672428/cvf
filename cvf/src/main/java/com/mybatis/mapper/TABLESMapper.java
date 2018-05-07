package com.mybatis.mapper;

import com.mybatis.pojo.TABLES;
import com.mybatis.pojo.TABLESExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TABLESMapper {
    int countByExample(TABLESExample example);

    int deleteByExample(TABLESExample example);

    int insert(TABLES record);

    int insertSelective(TABLES record);

    List<TABLES> selectByExample(TABLESExample example);

    int updateByExampleSelective(@Param("record") TABLES record, @Param("example") TABLESExample example);

    int updateByExample(@Param("record") TABLES record, @Param("example") TABLESExample example);
}