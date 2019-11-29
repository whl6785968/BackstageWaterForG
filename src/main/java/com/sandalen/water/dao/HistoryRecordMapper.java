package com.sandalen.water.dao;

import com.sandalen.water.bean.HistoryRecord;
import com.sandalen.water.bean.HistoryRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HistoryRecordMapper {
    int countByExample(HistoryRecordExample example);

    int deleteByExample(HistoryRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HistoryRecord record);

    int insertSelective(HistoryRecord record);

    List<HistoryRecord> selectByExample(HistoryRecordExample example);

    HistoryRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HistoryRecord record, @Param("example") HistoryRecordExample example);

    int updateByExample(@Param("record") HistoryRecord record, @Param("example") HistoryRecordExample example);

    int updateByPrimaryKeySelective(HistoryRecord record);

    int updateByPrimaryKey(HistoryRecord record);
}