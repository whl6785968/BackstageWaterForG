package com.sandalen.water.dao;

import com.sandalen.water.bean.StationProvince;
import com.sandalen.water.bean.StationProvinceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StationProvinceMapper {
    int countByExample(StationProvinceExample example);

    int deleteByExample(StationProvinceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StationProvince record);

    int insertSelective(StationProvince record);

    List<StationProvince> selectByExample(StationProvinceExample example);

    StationProvince selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StationProvince record, @Param("example") StationProvinceExample example);

    int updateByExample(@Param("record") StationProvince record, @Param("example") StationProvinceExample example);

    int updateByPrimaryKeySelective(StationProvince record);

    int updateByPrimaryKey(StationProvince record);
}