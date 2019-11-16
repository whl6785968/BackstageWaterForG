package com.sandalen.water.dao;

import com.sandalen.water.bean.Waterdata;
import com.sandalen.water.bean.WaterdataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterdataMapper {
    int countByExample(WaterdataExample example);

    int deleteByExample(WaterdataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Waterdata record);

    int insertSelective(Waterdata record);

    List<Waterdata> selectByExample(WaterdataExample example);

    Waterdata selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Waterdata record, @Param("example") WaterdataExample example);

    int updateByExample(@Param("record") Waterdata record, @Param("example") WaterdataExample example);

    int updateByPrimaryKeySelective(Waterdata record);

    int updateByPrimaryKey(Waterdata record);
}