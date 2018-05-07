package com.mybatis.mapper;

import com.mybatis.pojo.INNODB_LOCK_WAITS;
import com.mybatis.pojo.INNODB_LOCK_WAITSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface INNODB_LOCK_WAITSMapper {
    int countByExample(INNODB_LOCK_WAITSExample example);

    int deleteByExample(INNODB_LOCK_WAITSExample example);

    int insert(INNODB_LOCK_WAITS record);

    int insertSelective(INNODB_LOCK_WAITS record);

    List<INNODB_LOCK_WAITS> selectByExample(INNODB_LOCK_WAITSExample example);

    int updateByExampleSelective(@Param("record") INNODB_LOCK_WAITS record, @Param("example") INNODB_LOCK_WAITSExample example);

    int updateByExample(@Param("record") INNODB_LOCK_WAITS record, @Param("example") INNODB_LOCK_WAITSExample example);
}