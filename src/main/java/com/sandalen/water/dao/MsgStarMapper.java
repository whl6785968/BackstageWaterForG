package com.sandalen.water.dao;

import com.sandalen.water.bean.MsgStar;
import com.sandalen.water.bean.MsgStarExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MsgStarMapper {
    int countByExample(MsgStarExample example);

    int deleteByExample(MsgStarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MsgStar record);

    int insertSelective(MsgStar record);

    List<MsgStar> selectByExample(MsgStarExample example);

    MsgStar selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MsgStar record, @Param("example") MsgStarExample example);

    int updateByExample(@Param("record") MsgStar record, @Param("example") MsgStarExample example);

    int updateByPrimaryKeySelective(MsgStar record);

    int updateByPrimaryKey(MsgStar record);
}