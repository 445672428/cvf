package com.mybatis.mapper;

import com.mybatis.pojo.INNODB_TRX;
import com.mybatis.pojo.INNODB_TRXExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface INNODB_TRXMapper {
    int countByExample(INNODB_TRXExample example);

    int deleteByExample(INNODB_TRXExample example);

    int insert(INNODB_TRX record);

    int insertSelective(INNODB_TRX record);

    List<INNODB_TRX> selectByExample(INNODB_TRXExample example);

    int updateByExampleSelective(@Param("record") INNODB_TRX record, @Param("example") INNODB_TRXExample example);

    int updateByExample(@Param("record") INNODB_TRX record, @Param("example") INNODB_TRXExample example);
}