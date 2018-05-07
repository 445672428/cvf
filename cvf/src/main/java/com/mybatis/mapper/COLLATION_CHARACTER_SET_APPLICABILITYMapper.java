package com.mybatis.mapper;

import com.mybatis.pojo.COLLATION_CHARACTER_SET_APPLICABILITY;
import com.mybatis.pojo.COLLATION_CHARACTER_SET_APPLICABILITYExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface COLLATION_CHARACTER_SET_APPLICABILITYMapper {
    int countByExample(COLLATION_CHARACTER_SET_APPLICABILITYExample example);

    int deleteByExample(COLLATION_CHARACTER_SET_APPLICABILITYExample example);

    int insert(COLLATION_CHARACTER_SET_APPLICABILITY record);

    int insertSelective(COLLATION_CHARACTER_SET_APPLICABILITY record);

    List<COLLATION_CHARACTER_SET_APPLICABILITY> selectByExample(COLLATION_CHARACTER_SET_APPLICABILITYExample example);

    int updateByExampleSelective(@Param("record") COLLATION_CHARACTER_SET_APPLICABILITY record, @Param("example") COLLATION_CHARACTER_SET_APPLICABILITYExample example);

    int updateByExample(@Param("record") COLLATION_CHARACTER_SET_APPLICABILITY record, @Param("example") COLLATION_CHARACTER_SET_APPLICABILITYExample example);
}