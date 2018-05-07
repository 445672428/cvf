package com.mybatis.mapper;

import com.mybatis.pojo.SCHEMA_PRIVILEGES;
import com.mybatis.pojo.SCHEMA_PRIVILEGESExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SCHEMA_PRIVILEGESMapper {
    int countByExample(SCHEMA_PRIVILEGESExample example);

    int deleteByExample(SCHEMA_PRIVILEGESExample example);

    int insert(SCHEMA_PRIVILEGES record);

    int insertSelective(SCHEMA_PRIVILEGES record);

    List<SCHEMA_PRIVILEGES> selectByExample(SCHEMA_PRIVILEGESExample example);

    int updateByExampleSelective(@Param("record") SCHEMA_PRIVILEGES record, @Param("example") SCHEMA_PRIVILEGESExample example);

    int updateByExample(@Param("record") SCHEMA_PRIVILEGES record, @Param("example") SCHEMA_PRIVILEGESExample example);
}