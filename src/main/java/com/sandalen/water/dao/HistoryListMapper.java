package com.sandalen.water.dao;

import com.sandalen.water.bean.HistoryList;
import com.sandalen.water.bean.HistoryListExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HistoryListMapper {
    int countByExample(HistoryListExample example);

    int deleteByExample(HistoryListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HistoryList record);

    int insertSelective(HistoryList record);

    List<HistoryList> selectByExample(HistoryListExample example);

    HistoryList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HistoryList record, @Param("example") HistoryListExample example);

    int updateByExample(@Param("record") HistoryList record, @Param("example") HistoryListExample example);

    int updateByPrimaryKeySelective(HistoryList record);

    int updateByPrimaryKey(HistoryList record);
}