package com.mybatis.mapper;

import com.mybatis.pojo.INNODB_LOCKS;
import com.mybatis.pojo.INNODB_LOCKSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface INNODB_LOCKSMapper {
    int countByExample(INNODB_LOCKSExample example);

    int deleteByExample(INNODB_LOCKSExample example);

    int insert(INNODB_LOCKS record);

    int insertSelective(INNODB_LOCKS record);

    List<INNODB_LOCKS> selectByExample(INNODB_LOCKSExample example);

    int updateByExampleSelective(@Param("record") INNODB_LOCKS record, @Param("example") INNODB_LOCKSExample example);

    int updateByExample(@Param("record") INNODB_LOCKS record, @Param("example") INNODB_LOCKSExample example);
}