package com.sandalen.water.dao;

import com.sandalen.water.bean.StationDistrict;
import com.sandalen.water.bean.StationDistrictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StationDistrictMapper {
    int countByExample(StationDistrictExample example);

    int deleteByExample(StationDistrictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StationDistrict record);

    int insertSelective(StationDistrict record);

    List<StationDistrict> selectByExample(StationDistrictExample example);

    StationDistrict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StationDistrict record, @Param("example") StationDistrictExample example);

    int updateByExample(@Param("record") StationDistrict record, @Param("example") StationDistrictExample example);

    int updateByPrimaryKeySelective(StationDistrict record);

    int updateByPrimaryKey(StationDistrict record);
}