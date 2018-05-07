package com.mybatis.mapper;

import com.mybatis.pojo.INNODB_CMPMEM;
import com.mybatis.pojo.INNODB_CMPMEMExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface INNODB_CMPMEMMapper {
    int countByExample(INNODB_CMPMEMExample example);

    int deleteByExample(INNODB_CMPMEMExample example);

    int insert(INNODB_CMPMEM record);

    int insertSelective(INNODB_CMPMEM record);

    List<INNODB_CMPMEM> selectByExample(INNODB_CMPMEMExample example);

    int updateByExampleSelective(@Param("record") INNODB_CMPMEM record, @Param("example") INNODB_CMPMEMExample example);

    int updateByExample(@Param("record") INNODB_CMPMEM record, @Param("example") INNODB_CMPMEMExample example);
}