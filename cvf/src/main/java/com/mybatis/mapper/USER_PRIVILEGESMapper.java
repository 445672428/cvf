package com.mybatis.mapper;

import com.mybatis.pojo.USER_PRIVILEGES;
import com.mybatis.pojo.USER_PRIVILEGESExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface USER_PRIVILEGESMapper {
    int countByExample(USER_PRIVILEGESExample example);

    int deleteByExample(USER_PRIVILEGESExample example);

    int insert(USER_PRIVILEGES record);

    int insertSelective(USER_PRIVILEGES record);

    List<USER_PRIVILEGES> selectByExample(USER_PRIVILEGESExample example);

    int updateByExampleSelective(@Param("record") USER_PRIVILEGES record, @Param("example") USER_PRIVILEGESExample example);

    int updateByExample(@Param("record") USER_PRIVILEGES record, @Param("example") USER_PRIVILEGESExample example);
}