package com.sandalen.water.service;

import com.sandalen.water.bean.*;
import com.sandalen.water.dao.MenuMapper;
import com.sandalen.water.dao.RoleMapper;
import com.sandalen.water.dao.RoleMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames = "menu_cache")
public class MenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    public List<Integer> getMenuByRid(RoleMenuExample example){
        List<RoleMenu> roleMenus = roleMenuMapper.selectByExample(example);
        List<Integer> mids = new ArrayList<>();
        for(RoleMenu rm : roleMenus){
            mids.add(rm.getMenuId());
        }
        return mids;
    }


    public List<Menu> getAllMenuTree(){
        List<Menu> allMenuTree = menuMapper.getAllMenuTree();
        return allMenuTree;
    }

    public List<Role> getRoles(RoleExample example){
        List<Role> roles = roleMapper.selectByExample(example);
        return roles;
    }

    public void deleteAllRoleByRid(RoleMenuExample example){
        roleMenuMapper.deleteByExample(example);
    }

    public void updateRoleMenu(String role_id,int[] mids){
        for (int mid : mids){
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setMenuId(mid);
            roleMenu.setRoleId(role_id);
            roleMenuMapper.insert(roleMenu);
        }
    }

    public List<Menu> getAllMenu(){
        List<Menu> allMenu = menuMapper.getAllMenu();
        return allMenu;
    }
}
