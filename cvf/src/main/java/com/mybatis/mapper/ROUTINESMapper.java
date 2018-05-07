package com.mybatis.mapper;

import com.mybatis.pojo.ROUTINES;
import com.mybatis.pojo.ROUTINESExample;
import com.mybatis.pojo.ROUTINESWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ROUTINESMapper {
    int countByExample(ROUTINESExample example);

    int deleteByExample(ROUTINESExample example);

    int insert(ROUTINESWithBLOBs record);

    int insertSelective(ROUTINESWithBLOBs record);

    List<ROUTINESWithBLOBs> selectByExampleWithBLOBs(ROUTINESExample example);

    List<ROUTINES> selectByExample(ROUTINESExample example);

    int updateByExampleSelective(@Param("record") ROUTINESWithBLOBs record, @Param("example") ROUTINESExample example);

    int updateByExampleWithBLOBs(@Param("record") ROUTINESWithBLOBs record, @Param("example") ROUTINESExample example);

    int updateByExample(@Param("record") ROUTINES record, @Param("example") ROUTINESExample example);
}