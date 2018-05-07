package com.mybatis.mapper;

import com.mybatis.pojo.INNODB_CMP_RESET;
import com.mybatis.pojo.INNODB_CMP_RESETExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface INNODB_CMP_RESETMapper {
    int countByExample(INNODB_CMP_RESETExample example);

    int deleteByExample(INNODB_CMP_RESETExample example);

    int insert(INNODB_CMP_RESET record);

    int insertSelective(INNODB_CMP_RESET record);

    List<INNODB_CMP_RESET> selectByExample(INNODB_CMP_RESETExample example);

    int updateByExampleSelective(@Param("record") INNODB_CMP_RESET record, @Param("example") INNODB_CMP_RESETExample example);

    int updateByExample(@Param("record") INNODB_CMP_RESET record, @Param("example") INNODB_CMP_RESETExample example);
}