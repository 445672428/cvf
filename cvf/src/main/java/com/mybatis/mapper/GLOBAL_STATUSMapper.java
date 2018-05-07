package com.mybatis.mapper;

import com.mybatis.pojo.GLOBAL_STATUS;
import com.mybatis.pojo.GLOBAL_STATUSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GLOBAL_STATUSMapper {
    int countByExample(GLOBAL_STATUSExample example);

    int deleteByExample(GLOBAL_STATUSExample example);

    int insert(GLOBAL_STATUS record);

    int insertSelective(GLOBAL_STATUS record);

    List<GLOBAL_STATUS> selectByExample(GLOBAL_STATUSExample example);

    int updateByExampleSelective(@Param("record") GLOBAL_STATUS record, @Param("example") GLOBAL_STATUSExample example);

    int updateByExample(@Param("record") GLOBAL_STATUS record, @Param("example") GLOBAL_STATUSExample example);
}