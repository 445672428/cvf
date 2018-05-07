package com.mybatis.mapper;

import com.mybatis.pojo.TABLESPACES;
import com.mybatis.pojo.TABLESPACESExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TABLESPACESMapper {
    int countByExample(TABLESPACESExample example);

    int deleteByExample(TABLESPACESExample example);

    int insert(TABLESPACES record);

    int insertSelective(TABLESPACES record);

    List<TABLESPACES> selectByExample(TABLESPACESExample example);

    int updateByExampleSelective(@Param("record") TABLESPACES record, @Param("example") TABLESPACESExample example);

    int updateByExample(@Param("record") TABLESPACES record, @Param("example") TABLESPACESExample example);
}