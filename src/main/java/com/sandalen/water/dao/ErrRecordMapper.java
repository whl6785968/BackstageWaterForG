package com.sandalen.water.dao;

import com.sandalen.water.bean.ErrRecord;
import com.sandalen.water.bean.ErrRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ErrRecordMapper {
    int countByExample(ErrRecordExample example);

    int deleteByExample(ErrRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ErrRecord record);

    int insertSelective(ErrRecord record);

    List<ErrRecord> selectByExample(ErrRecordExample example);

    ErrRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ErrRecord record, @Param("example") ErrRecordExample example);

    int updateByExample(@Param("record") ErrRecord record, @Param("example") ErrRecordExample example);

    int updateByPrimaryKeySelective(ErrRecord record);

    int updateByPrimaryKey(ErrRecord record);
}