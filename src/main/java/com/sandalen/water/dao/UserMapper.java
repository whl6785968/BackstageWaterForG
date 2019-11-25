package com.sandalen.water.dao;

import com.sandalen.water.bean.User;
import com.sandalen.water.bean.UserExample;
import java.util.List;

import com.sandalen.water.vo.UserRoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<UserRoleVo> getUserRole();

    UserRoleVo getRoleByUserId(String user_id);

    List<User> getAdminUser();

    List<String> getNormalUser();
}