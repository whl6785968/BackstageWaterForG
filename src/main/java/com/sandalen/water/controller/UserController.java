package com.sandalen.water.controller;

import com.sandalen.water.bean.Menu;
import com.sandalen.water.bean.RespBean;
import com.sandalen.water.bean.Role;
import com.sandalen.water.service.UserService;
import com.sandalen.water.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user/basic")
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/getRoleById")
    public RespBean getRoleById(String userid){
        System.out.println(userid);
        Role role = userService.getRoleById(userid);
        if(role == null){
            return RespBean.error("获取角色失败");
        }

        return RespBean.ok("获取成功",role);
    }

    @RequestMapping("/getMenuList")
    public RespBean getMenuList(String userid){
        System.out.println(userid);
        List<Menu> menus = userService.getMenuByUserId(userid);
        if(menus != null){
            return RespBean.ok("成功获取数据",menus);
        }
        return RespBean.error("获取数据失败");

    }



}
