package com.mybatis.mapper;

import com.mybatis.pojo.SESSION_STATUS;
import com.mybatis.pojo.SESSION_STATUSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SESSION_STATUSMapper {
    int countByExample(SESSION_STATUSExample example);

    int deleteByExample(SESSION_STATUSExample example);

    int insert(SESSION_STATUS record);

    int insertSelective(SESSION_STATUS record);

    List<SESSION_STATUS> selectByExample(SESSION_STATUSExample example);

    int updateByExampleSelective(@Param("record") SESSION_STATUS record, @Param("example") SESSION_STATUSExample example);

    int updateByExample(@Param("record") SESSION_STATUS record, @Param("example") SESSION_STATUSExample example);
}