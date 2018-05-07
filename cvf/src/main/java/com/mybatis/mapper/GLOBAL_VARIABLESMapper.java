package com.mybatis.mapper;

import com.mybatis.pojo.GLOBAL_VARIABLES;
import com.mybatis.pojo.GLOBAL_VARIABLESExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GLOBAL_VARIABLESMapper {
    int countByExample(GLOBAL_VARIABLESExample example);

    int deleteByExample(GLOBAL_VARIABLESExample example);

    int insert(GLOBAL_VARIABLES record);

    int insertSelective(GLOBAL_VARIABLES record);

    List<GLOBAL_VARIABLES> selectByExample(GLOBAL_VARIABLESExample example);

    int updateByExampleSelective(@Param("record") GLOBAL_VARIABLES record, @Param("example") GLOBAL_VARIABLESExample example);

    int updateByExample(@Param("record") GLOBAL_VARIABLES record, @Param("example") GLOBAL_VARIABLESExample example);
}