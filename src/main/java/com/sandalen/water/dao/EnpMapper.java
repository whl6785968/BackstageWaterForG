package com.sandalen.water.dao;

import com.sandalen.water.bean.Enp;
import com.sandalen.water.bean.EnpExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EnpMapper {
    int countByExample(EnpExample example);

    int deleteByExample(EnpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Enp record);

    int insertSelective(Enp record);

    List<Enp> selectByExample(EnpExample example);

    Enp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Enp record, @Param("example") EnpExample example);

    int updateByExample(@Param("record") Enp record, @Param("example") EnpExample example);

    int updateByPrimaryKeySelective(Enp record);

    int updateByPrimaryKey(Enp record);

    List<Enp> getAllEnp();
}