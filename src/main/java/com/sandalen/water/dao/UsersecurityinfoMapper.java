package com.sandalen.water.dao;

import com.sandalen.water.bean.Usersecurityinfo;
import com.sandalen.water.bean.UsersecurityinfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UsersecurityinfoMapper {
    int countByExample(UsersecurityinfoExample example);

    int deleteByExample(UsersecurityinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usersecurityinfo record);

    int insertSelective(Usersecurityinfo record);

    List<Usersecurityinfo> selectByExample(UsersecurityinfoExample example);

    Usersecurityinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usersecurityinfo record, @Param("example") UsersecurityinfoExample example);

    int updateByExample(@Param("record") Usersecurityinfo record, @Param("example") UsersecurityinfoExample example);

    int updateByPrimaryKeySelective(Usersecurityinfo record);

    int updateByPrimaryKey(Usersecurityinfo record);
}