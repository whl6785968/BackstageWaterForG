package com.sandalen.water.dao;

import com.sandalen.water.bean.EquipSta;
import com.sandalen.water.bean.EquipStaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipStaMapper {
    int countByExample(EquipStaExample example);

    int deleteByExample(EquipStaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EquipSta record);

    int insertSelective(EquipSta record);

    List<EquipSta> selectByExample(EquipStaExample example);

    EquipSta selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EquipSta record, @Param("example") EquipStaExample example);

    int updateByExample(@Param("record") EquipSta record, @Param("example") EquipStaExample example);

    int updateByPrimaryKeySelective(EquipSta record);

    int updateByPrimaryKey(EquipSta record);
}