package com.mybatis.mapper;

import com.mybatis.pojo.REFERENTIAL_CONSTRAINTS;
import com.mybatis.pojo.REFERENTIAL_CONSTRAINTSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface REFERENTIAL_CONSTRAINTSMapper {
    int countByExample(REFERENTIAL_CONSTRAINTSExample example);

    int deleteByExample(REFERENTIAL_CONSTRAINTSExample example);

    int insert(REFERENTIAL_CONSTRAINTS record);

    int insertSelective(REFERENTIAL_CONSTRAINTS record);

    List<REFERENTIAL_CONSTRAINTS> selectByExample(REFERENTIAL_CONSTRAINTSExample example);

    int updateByExampleSelective(@Param("record") REFERENTIAL_CONSTRAINTS record, @Param("example") REFERENTIAL_CONSTRAINTSExample example);

    int updateByExample(@Param("record") REFERENTIAL_CONSTRAINTS record, @Param("example") REFERENTIAL_CONSTRAINTSExample example);
}