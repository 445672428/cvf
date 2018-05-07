package com.mybatis.mapper;

import com.mybatis.pojo.VIEWS;
import com.mybatis.pojo.VIEWSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VIEWSMapper {
    int countByExample(VIEWSExample example);

    int deleteByExample(VIEWSExample example);

    int insert(VIEWS record);

    int insertSelective(VIEWS record);

    List<VIEWS> selectByExampleWithBLOBs(VIEWSExample example);

    List<VIEWS> selectByExample(VIEWSExample example);

    int updateByExampleSelective(@Param("record") VIEWS record, @Param("example") VIEWSExample example);

    int updateByExampleWithBLOBs(@Param("record") VIEWS record, @Param("example") VIEWSExample example);

    int updateByExample(@Param("record") VIEWS record, @Param("example") VIEWSExample example);
}