package com.sandalen.water.dao;

import com.sandalen.water.bean.ComplexKg;
import com.sandalen.water.bean.ComplexKgExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ComplexKgMapper {
    int countByExample(ComplexKgExample example);

    int deleteByExample(ComplexKgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ComplexKg record);

    int insertSelective(ComplexKg record);

    List<ComplexKg> selectByExample(ComplexKgExample example);

    ComplexKg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ComplexKg record, @Param("example") ComplexKgExample example);

    int updateByExample(@Param("record") ComplexKg record, @Param("example") ComplexKgExample example);

    int updateByPrimaryKeySelective(ComplexKg record);

    int updateByPrimaryKey(ComplexKg record);
}