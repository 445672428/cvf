package com.mybatis.mapper;

import com.mybatis.pojo.ENGINES;
import com.mybatis.pojo.ENGINESExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ENGINESMapper {
    int countByExample(ENGINESExample example);

    int deleteByExample(ENGINESExample example);

    int insert(ENGINES record);

    int insertSelective(ENGINES record);

    List<ENGINES> selectByExample(ENGINESExample example);

    int updateByExampleSelective(@Param("record") ENGINES record, @Param("example") ENGINESExample example);

    int updateByExample(@Param("record") ENGINES record, @Param("example") ENGINESExample example);
}