package com.sandalen.water.service;

import com.sandalen.water.bean.Menu;
import com.sandalen.water.bean.User;
import com.sandalen.water.bean.UserExample;
import com.sandalen.water.bean.UserRole;
import com.sandalen.water.dao.MenuMapper;
import com.sandalen.water.dao.UserMapper;
import com.sandalen.water.dao.UserRoleMapper;
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
}
