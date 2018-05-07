package com.mybatis.mapper;

import com.mybatis.pojo.INNODB_CMP;
import com.mybatis.pojo.INNODB_CMPExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface INNODB_CMPMapper {
    int countByExample(INNODB_CMPExample example);

    int deleteByExample(INNODB_CMPExample example);

    int insert(INNODB_CMP record);

    int insertSelective(INNODB_CMP record);

    List<INNODB_CMP> selectByExample(INNODB_CMPExample example);

    int updateByExampleSelective(@Param("record") INNODB_CMP record, @Param("example") INNODB_CMPExample example);

    int updateByExample(@Param("record") INNODB_CMP record, @Param("example") INNODB_CMPExample example);
}