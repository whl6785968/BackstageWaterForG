package com.sandalen.water.dao;

import com.sandalen.water.bean.Station;
import com.sandalen.water.bean.StationExample;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StationMapper {
    int countByExample(StationExample example);

    int deleteByExample(StationExample example);

    int deleteByPrimaryKey(String id);

    int insert(Station record);

    int insertSelective(Station record);

    List<Station> selectByExample(StationExample example);

    Station selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Station record, @Param("example") StationExample example);

    int updateByExample(@Param("record") Station record, @Param("example") StationExample example);

    int updateByPrimaryKeySelective(Station record);

    int updateByPrimaryKey(Station record);

    List<Station> getAllInfoForStation(Map<String, Object> map);

    List<Station> getCountByLevel();

    List<Station> getStationByDistrict(String id);

    int getCountByDistrict(Map map);
}