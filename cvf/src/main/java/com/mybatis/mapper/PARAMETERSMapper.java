package com.mybatis.mapper;

import com.mybatis.pojo.PARAMETERS;
import com.mybatis.pojo.PARAMETERSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PARAMETERSMapper {
    int countByExample(PARAMETERSExample example);

    int deleteByExample(PARAMETERSExample example);

    int insert(PARAMETERS record);

    int insertSelective(PARAMETERS record);

    List<PARAMETERS> selectByExampleWithBLOBs(PARAMETERSExample example);

    List<PARAMETERS> selectByExample(PARAMETERSExample example);

    int updateByExampleSelective(@Param("record") PARAMETERS record, @Param("example") PARAMETERSExample example);

    int updateByExampleWithBLOBs(@Param("record") PARAMETERS record, @Param("example") PARAMETERSExample example);

    int updateByExample(@Param("record") PARAMETERS record, @Param("example") PARAMETERSExample example);
}