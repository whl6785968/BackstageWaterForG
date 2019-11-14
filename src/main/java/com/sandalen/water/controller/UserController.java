package com.sandalen.water.controller;

import com.alibaba.fastjson.JSONObject;
import com.sandalen.water.bean.*;
import com.sandalen.water.enumeration.ResultCode;
import com.sandalen.water.service.UserService;
import com.sandalen.water.util.CookieUtils;
import com.sandalen.water.util.JwtUtils;
import com.sandalen.water.vo.UserRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping("/getMenuList")
    public RespBean getMenuList(String userid){
        System.out.println(userid);
        List<Menu> menus = userService.getMenuByUserId(userid);
        if(menus != null){
            return RespBean.ok("成功获取数据",menus);
        }
        return RespBean.error("获取数据失败");

    }

    @RequestMapping("/getAllRole")
    public RespBean getAllRole(){
        List<UserRoleVo> userRole = userService.getUserRole();
        if (userRole != null){
            return RespBean.ok("成功获取数据",userRole);
        }
        return RespBean.error("获取数据失败");
    }

    @RequestMapping("/getRoleByUserId")
    public RespBean getRoleByUserId(String user_id){
        UserRoleVo roleByUserId = userService.getRoleByUserId(user_id);
        if(roleByUserId != null){
            return RespBean.ok("成功获取数据",roleByUserId);
        }
        return RespBean.error("获取数据失败");
    }


    @RequestMapping("/changeRole")
    public RespBean changeRole(int id,String user_id,String role_id){
        System.out.println(id);
        UserRole userRole = new UserRole();
        userRole.setId(id);
        userRole.setUserId(user_id);
        userRole.setRoleId(role_id);
        int i = userService.changeRole(userRole);
        if(i != -1){
            return RespBean.ok("修改权限成功");
        }

        return RespBean.error("修改权限失败");

    }

    @RequestMapping("/getRoleById")
    public RespBean getRoleById(String userid){
        System.out.println(userid);
        Role role = userService.getRoleById(userid);
        if(role == null){
            return RespBean.error("获取角色失败");
        }

        return RespBean.ok("获取成功",role);
    }


}
