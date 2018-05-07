package com.mybatis.mapper;

import com.mybatis.pojo.EVENTS;
import com.mybatis.pojo.EVENTSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EVENTSMapper {
    int countByExample(EVENTSExample example);

    int deleteByExample(EVENTSExample example);

    int insert(EVENTS record);

    int insertSelective(EVENTS record);

    List<EVENTS> selectByExampleWithBLOBs(EVENTSExample example);

    List<EVENTS> selectByExample(EVENTSExample example);

    int updateByExampleSelective(@Param("record") EVENTS record, @Param("example") EVENTSExample example);

    int updateByExampleWithBLOBs(@Param("record") EVENTS record, @Param("example") EVENTSExample example);

    int updateByExample(@Param("record") EVENTS record, @Param("example") EVENTSExample example);
}