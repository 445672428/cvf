package com.mybatis.mapper;

import com.mybatis.pojo.KEY_COLUMN_USAGE;
import com.mybatis.pojo.KEY_COLUMN_USAGEExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KEY_COLUMN_USAGEMapper {
    int countByExample(KEY_COLUMN_USAGEExample example);

    int deleteByExample(KEY_COLUMN_USAGEExample example);

    int insert(KEY_COLUMN_USAGE record);

    int insertSelective(KEY_COLUMN_USAGE record);

    List<KEY_COLUMN_USAGE> selectByExample(KEY_COLUMN_USAGEExample example);

    int updateByExampleSelective(@Param("record") KEY_COLUMN_USAGE record, @Param("example") KEY_COLUMN_USAGEExample example);

    int updateByExample(@Param("record") KEY_COLUMN_USAGE record, @Param("example") KEY_COLUMN_USAGEExample example);
}