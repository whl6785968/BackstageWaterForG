package com.sandalen.water.dao;

import com.sandalen.water.bean.EtsSta;
import com.sandalen.water.bean.EtsStaExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface EtsStaMapper {
    int countByExample(EtsStaExample example);

    int deleteByExample(EtsStaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtsSta record);

    int insertSelective(EtsSta record);

    List<EtsSta> selectByExample(EtsStaExample example);

    EtsSta selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EtsSta record, @Param("example") EtsStaExample example);

    int updateByExample(@Param("record") EtsSta record, @Param("example") EtsStaExample example);

    int updateByPrimaryKeySelective(EtsSta record);

    int updateByPrimaryKey(EtsSta record);
}