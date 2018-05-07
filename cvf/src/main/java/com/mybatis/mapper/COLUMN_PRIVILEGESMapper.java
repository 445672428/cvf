package com.mybatis.mapper;

import com.mybatis.pojo.COLUMN_PRIVILEGES;
import com.mybatis.pojo.COLUMN_PRIVILEGESExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface COLUMN_PRIVILEGESMapper {
    int countByExample(COLUMN_PRIVILEGESExample example);

    int deleteByExample(COLUMN_PRIVILEGESExample example);

    int insert(COLUMN_PRIVILEGES record);

    int insertSelective(COLUMN_PRIVILEGES record);

    List<COLUMN_PRIVILEGES> selectByExample(COLUMN_PRIVILEGESExample example);

    int updateByExampleSelective(@Param("record") COLUMN_PRIVILEGES record, @Param("example") COLUMN_PRIVILEGESExample example);

    int updateByExample(@Param("record") COLUMN_PRIVILEGES record, @Param("example") COLUMN_PRIVILEGESExample example);
}