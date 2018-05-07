package com.mybatis.mapper;

import com.mybatis.pojo.PROFILING;
import com.mybatis.pojo.PROFILINGExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PROFILINGMapper {
    int countByExample(PROFILINGExample example);

    int deleteByExample(PROFILINGExample example);

    int insert(PROFILING record);

    int insertSelective(PROFILING record);

    List<PROFILING> selectByExample(PROFILINGExample example);

    int updateByExampleSelective(@Param("record") PROFILING record, @Param("example") PROFILINGExample example);

    int updateByExample(@Param("record") PROFILING record, @Param("example") PROFILINGExample example);
}