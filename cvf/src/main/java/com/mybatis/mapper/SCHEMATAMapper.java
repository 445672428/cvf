package com.mybatis.mapper;

import com.mybatis.pojo.SCHEMATA;
import com.mybatis.pojo.SCHEMATAExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SCHEMATAMapper {
    int countByExample(SCHEMATAExample example);

    int deleteByExample(SCHEMATAExample example);

    int insert(SCHEMATA record);

    int insertSelective(SCHEMATA record);

    List<SCHEMATA> selectByExample(SCHEMATAExample example);

    int updateByExampleSelective(@Param("record") SCHEMATA record, @Param("example") SCHEMATAExample example);

    int updateByExample(@Param("record") SCHEMATA record, @Param("example") SCHEMATAExample example);
}