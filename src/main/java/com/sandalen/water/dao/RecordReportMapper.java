package com.sandalen.water.dao;

import com.sandalen.water.bean.RecordReport;
import com.sandalen.water.bean.RecordReportExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RecordReportMapper {
    int countByExample(RecordReportExample example);

    int deleteByExample(RecordReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RecordReport record);

    int insertSelective(RecordReport record);

    List<RecordReport> selectByExample(RecordReportExample example);

    RecordReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RecordReport record, @Param("example") RecordReportExample example);

    int updateByExample(@Param("record") RecordReport record, @Param("example") RecordReportExample example);

    int updateByPrimaryKeySelective(RecordReport record);

    int updateByPrimaryKey(RecordReport record);
}