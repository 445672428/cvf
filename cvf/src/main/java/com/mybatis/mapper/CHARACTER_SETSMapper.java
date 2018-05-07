package com.mybatis.mapper;

import com.mybatis.pojo.CHARACTER_SETS;
import com.mybatis.pojo.CHARACTER_SETSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CHARACTER_SETSMapper {
    int countByExample(CHARACTER_SETSExample example);

    int deleteByExample(CHARACTER_SETSExample example);

    int insert(CHARACTER_SETS record);

    int insertSelective(CHARACTER_SETS record);

    List<CHARACTER_SETS> selectByExample(CHARACTER_SETSExample example);

    int updateByExampleSelective(@Param("record") CHARACTER_SETS record, @Param("example") CHARACTER_SETSExample example);

    int updateByExample(@Param("record") CHARACTER_SETS record, @Param("example") CHARACTER_SETSExample example);
}