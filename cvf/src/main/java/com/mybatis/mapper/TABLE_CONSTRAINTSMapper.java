package com.mybatis.mapper;

import com.mybatis.pojo.TABLE_CONSTRAINTS;
import com.mybatis.pojo.TABLE_CONSTRAINTSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TABLE_CONSTRAINTSMapper {
    int countByExample(TABLE_CONSTRAINTSExample example);

    int deleteByExample(TABLE_CONSTRAINTSExample example);

    int insert(TABLE_CONSTRAINTS record);

    int insertSelective(TABLE_CONSTRAINTS record);

    List<TABLE_CONSTRAINTS> selectByExample(TABLE_CONSTRAINTSExample example);

    int updateByExampleSelective(@Param("record") TABLE_CONSTRAINTS record, @Param("example") TABLE_CONSTRAINTSExample example);

    int updateByExample(@Param("record") TABLE_CONSTRAINTS record, @Param("example") TABLE_CONSTRAINTSExample example);
}