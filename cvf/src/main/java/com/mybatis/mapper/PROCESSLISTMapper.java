package com.mybatis.mapper;

import com.mybatis.pojo.PROCESSLIST;
import com.mybatis.pojo.PROCESSLISTExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PROCESSLISTMapper {
    int countByExample(PROCESSLISTExample example);

    int deleteByExample(PROCESSLISTExample example);

    int insert(PROCESSLIST record);

    int insertSelective(PROCESSLIST record);

    List<PROCESSLIST> selectByExampleWithBLOBs(PROCESSLISTExample example);

    List<PROCESSLIST> selectByExample(PROCESSLISTExample example);

    int updateByExampleSelective(@Param("record") PROCESSLIST record, @Param("example") PROCESSLISTExample example);

    int updateByExampleWithBLOBs(@Param("record") PROCESSLIST record, @Param("example") PROCESSLISTExample example);

    int updateByExample(@Param("record") PROCESSLIST record, @Param("example") PROCESSLISTExample example);
}