package com.mybatis.mapper;

import com.mybatis.pojo.TRIGGERS;
import com.mybatis.pojo.TRIGGERSExample;
import com.mybatis.pojo.TRIGGERSWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRIGGERSMapper {
    int countByExample(TRIGGERSExample example);

    int deleteByExample(TRIGGERSExample example);

    int insert(TRIGGERSWithBLOBs record);

    int insertSelective(TRIGGERSWithBLOBs record);

    List<TRIGGERSWithBLOBs> selectByExampleWithBLOBs(TRIGGERSExample example);

    List<TRIGGERS> selectByExample(TRIGGERSExample example);

    int updateByExampleSelective(@Param("record") TRIGGERSWithBLOBs record, @Param("example") TRIGGERSExample example);

    int updateByExampleWithBLOBs(@Param("record") TRIGGERSWithBLOBs record, @Param("example") TRIGGERSExample example);

    int updateByExample(@Param("record") TRIGGERS record, @Param("example") TRIGGERSExample example);
}