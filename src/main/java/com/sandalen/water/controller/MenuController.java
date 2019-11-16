package com.sandalen.water.controller;

import com.sandalen.water.bean.*;
import com.sandalen.water.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/sys/menu")
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/getAllMenuTree/{role_id}")
    public RespBean getAllMenuTree(@PathVariable String role_id){
        RoleMenuExample roleMenuExample = new RoleMenuExample();
        RoleMenuExample.Criteria criteria = roleMenuExample.createCriteria();
        criteria.andRoleIdEqualTo(role_id);
        List<Integer> mids = menuService.getMenuByRid(roleMenuExample);

        List<Menu> allMenuTree = menuService.getAllMenuTree();

        Map<String,Object> map = new HashMap<>();
        map.put("mids",mids);
        map.put("menus",allMenuTree);

        return RespBean.ok("成功获取数据",map);

    }

    @RequestMapping("/getRoles")
    public RespBean getRoles(){
        RoleExample example = new RoleExample();
        List<Role> roles = menuService.getRoles(example);
        if(roles != null){
            return RespBean.ok("成功获取数据",roles);
        }
        return RespBean.error("获取数据失败");
    }

    @RequestMapping("/updateRoleMenu")
    public RespBean updateRoleMenu(String role_id,int[] mids){
        RoleMenuExample roleMenuExample = new RoleMenuExample();
        RoleMenuExample.Criteria criteria = roleMenuExample.createCriteria();
        criteria.andRoleIdEqualTo(role_id);
        menuService.deleteAllRoleByRid(roleMenuExample);

        menuService.updateRoleMenu(role_id,mids);

        if(role_id != null){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @RequestMapping("/getAllMenu")
    public RespBean getAllMenu(){
        List<Menu> allMenu = menuService.getAllMenu();
        return RespBean.ok("成功获取数据",allMenu);
    }

}
