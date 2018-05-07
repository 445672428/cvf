package com.mybatis.mapper;

import com.mybatis.pojo.FILES;
import com.mybatis.pojo.FILESExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FILESMapper {
    int countByExample(FILESExample example);

    int deleteByExample(FILESExample example);

    int insert(FILES record);

    int insertSelective(FILES record);

    List<FILES> selectByExample(FILESExample example);

    int updateByExampleSelective(@Param("record") FILES record, @Param("example") FILESExample example);

    int updateByExample(@Param("record") FILES record, @Param("example") FILESExample example);
}