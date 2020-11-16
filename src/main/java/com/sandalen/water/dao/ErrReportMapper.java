package com.sandalen.water.dao;

import com.sandalen.water.bean.ErrReport;
import com.sandalen.water.bean.ErrReportExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ErrReportMapper {
    int countByExample(ErrReportExample example);

    int deleteByExample(ErrReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ErrReport record);

    int insertSelective(ErrReport record);

    List<ErrReport> selectByExample(ErrReportExample example);

    ErrReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ErrReport record, @Param("example") ErrReportExample example);

    int updateByExample(@Param("record") ErrReport record, @Param("example") ErrReportExample example);

    int updateByPrimaryKeySelective(ErrReport record);

    int updateByPrimaryKey(ErrReport record);
}