package com.mybatis.mapper;

import com.mybatis.pojo.STATISTICS;
import com.mybatis.pojo.STATISTICSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface STATISTICSMapper {
    int countByExample(STATISTICSExample example);

    int deleteByExample(STATISTICSExample example);

    int insert(STATISTICS record);

    int insertSelective(STATISTICS record);

    List<STATISTICS> selectByExample(STATISTICSExample example);

    int updateByExampleSelective(@Param("record") STATISTICS record, @Param("example") STATISTICSExample example);

    int updateByExample(@Param("record") STATISTICS record, @Param("example") STATISTICSExample example);
}