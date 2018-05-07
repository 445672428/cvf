package com.mybatis.mapper;

import com.mybatis.pojo.INNODB_CMPMEM_RESET;
import com.mybatis.pojo.INNODB_CMPMEM_RESETExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface INNODB_CMPMEM_RESETMapper {
    int countByExample(INNODB_CMPMEM_RESETExample example);

    int deleteByExample(INNODB_CMPMEM_RESETExample example);

    int insert(INNODB_CMPMEM_RESET record);

    int insertSelective(INNODB_CMPMEM_RESET record);

    List<INNODB_CMPMEM_RESET> selectByExample(INNODB_CMPMEM_RESETExample example);

    int updateByExampleSelective(@Param("record") INNODB_CMPMEM_RESET record, @Param("example") INNODB_CMPMEM_RESETExample example);

    int updateByExample(@Param("record") INNODB_CMPMEM_RESET record, @Param("example") INNODB_CMPMEM_RESETExample example);
}