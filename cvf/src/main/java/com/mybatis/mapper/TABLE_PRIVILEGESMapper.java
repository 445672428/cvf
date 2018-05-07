package com.mybatis.mapper;

import com.mybatis.pojo.TABLE_PRIVILEGES;
import com.mybatis.pojo.TABLE_PRIVILEGESExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TABLE_PRIVILEGESMapper {
    int countByExample(TABLE_PRIVILEGESExample example);

    int deleteByExample(TABLE_PRIVILEGESExample example);

    int insert(TABLE_PRIVILEGES record);

    int insertSelective(TABLE_PRIVILEGES record);

    List<TABLE_PRIVILEGES> selectByExample(TABLE_PRIVILEGESExample example);

    int updateByExampleSelective(@Param("record") TABLE_PRIVILEGES record, @Param("example") TABLE_PRIVILEGESExample example);

    int updateByExample(@Param("record") TABLE_PRIVILEGES record, @Param("example") TABLE_PRIVILEGESExample example);
}