package com.sandalen.water.service;

import com.sandalen.water.bean.*;
import com.sandalen.water.dao.MenuMapper;
import com.sandalen.water.dao.UserMapper;
import com.sandalen.water.dao.UserRoleMapper;
import com.sandalen.water.dao.UserinfoMapper;
import com.sandalen.water.vo.UserRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    public List<Menu> getMenuByUserId(String userId){
        List<Menu> menus = menuMapper.getMenuByUserId(userId);
        return menus;
    }

    public User getUser(UserExample userExample){
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null){
            return users.get(0);
        }
        return null;
    }

    public List<UserRoleVo> getUserRole(){
        List<UserRoleVo> userRole = userMapper.getUserRole();
        if(userRole != null){
            return userRole;
        }
        return null;
    }

    public UserRoleVo getRoleByUserId(String user_id){
        UserRoleVo roleByUserId = userMapper.getRoleByUserId(user_id);
        if(roleByUserId != null){
            return roleByUserId;
        }
        return null;
    }

    public int changeRole(UserRole userRole){
        int i = userRoleMapper.updateByPrimaryKeySelective(userRole);
        return i;
    }

    public Role getRoleById(String userid){
        Role role = userRoleMapper.getRoleByUserId(userid);
        return role;
    }

    public Userinfo getUserDetailsById(String userId){
        UserinfoExample example = new UserinfoExample();
        UserinfoExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(userId);

        List<Userinfo> userdetails = userinfoMapper.selectByExample(example);
        if(userdetails != null){
            return userdetails.get(0);
        }
        return null;
    }

    public void updateUserDetails(Userinfo userdetails){
        userinfoMapper.updateByPrimaryKey(userdetails);
    }

    public List<User> getAdminUser(){
        List<User> adminUser = userMapper.getAdminUser();
        return adminUser;
    }
}
