package com.mybatis.mapper;

import com.mybatis.pojo.COLUMNS;
import com.mybatis.pojo.COLUMNSExample;
import com.mybatis.pojo.COLUMNSWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface COLUMNSMapper {
    int countByExample(COLUMNSExample example);

    int deleteByExample(COLUMNSExample example);

    int insert(COLUMNSWithBLOBs record);

    int insertSelective(COLUMNSWithBLOBs record);

    List<COLUMNSWithBLOBs> selectByExampleWithBLOBs(COLUMNSExample example);

    List<COLUMNS> selectByExample(COLUMNSExample example);

    int updateByExampleSelective(@Param("record") COLUMNSWithBLOBs record, @Param("example") COLUMNSExample example);

    int updateByExampleWithBLOBs(@Param("record") COLUMNSWithBLOBs record, @Param("example") COLUMNSExample example);

    int updateByExample(@Param("record") COLUMNS record, @Param("example") COLUMNSExample example);
}