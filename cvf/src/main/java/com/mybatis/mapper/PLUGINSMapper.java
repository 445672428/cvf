package com.mybatis.mapper;

import com.mybatis.pojo.PLUGINS;
import com.mybatis.pojo.PLUGINSExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PLUGINSMapper {
    int countByExample(PLUGINSExample example);

    int deleteByExample(PLUGINSExample example);

    int insert(PLUGINS record);

    int insertSelective(PLUGINS record);

    List<PLUGINS> selectByExampleWithBLOBs(PLUGINSExample example);

    List<PLUGINS> selectByExample(PLUGINSExample example);

    int updateByExampleSelective(@Param("record") PLUGINS record, @Param("example") PLUGINSExample example);

    int updateByExampleWithBLOBs(@Param("record") PLUGINS record, @Param("example") PLUGINSExample example);

    int updateByExample(@Param("record") PLUGINS record, @Param("example") PLUGINSExample example);
}