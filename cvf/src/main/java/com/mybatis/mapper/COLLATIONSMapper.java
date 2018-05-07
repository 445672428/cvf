package com.mybatis.mapper;

import com.mybatis.pojo.COLLATIONS;
import com.mybatis.pojo.COLLATIONSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface COLLATIONSMapper {
    int countByExample(COLLATIONSExample example);

    int deleteByExample(COLLATIONSExample example);

    int insert(COLLATIONS record);

    int insertSelective(COLLATIONS record);

    List<COLLATIONS> selectByExample(COLLATIONSExample example);

    int updateByExampleSelective(@Param("record") COLLATIONS record, @Param("example") COLLATIONSExample example);

    int updateByExample(@Param("record") COLLATIONS record, @Param("example") COLLATIONSExample example);
}