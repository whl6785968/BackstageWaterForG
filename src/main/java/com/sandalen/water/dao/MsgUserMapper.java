package com.sandalen.water.dao;

import com.sandalen.water.bean.MsgUser;
import com.sandalen.water.bean.MsgUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MsgUserMapper {
    int countByExample(MsgUserExample example);

    int deleteByExample(MsgUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MsgUser record);

    int insertSelective(MsgUser record);

    List<MsgUser> selectByExample(MsgUserExample example);

    MsgUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MsgUser record, @Param("example") MsgUserExample example);

    int updateByExample(@Param("record") MsgUser record, @Param("example") MsgUserExample example);

    int updateByPrimaryKeySelective(MsgUser record);

    int updateByPrimaryKey(MsgUser record);
}