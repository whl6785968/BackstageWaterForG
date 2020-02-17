package com.sandalen.water.controller;

import com.sandalen.water.bean.*;
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

    @RequestMapping("/getUserInfo")
    public RespBean getUserInfo(String userid){
        Userinfo userinfo = userService.getUserDetailsById(userid);
        if(userinfo != null){
            return RespBean.ok("成功获取数据",userinfo);
        }
        return RespBean.error("获取数据失败");
    }

    @RequestMapping("/updateUserInfo")
    public RespBean updateUserInfo(String link,String descr,String userid){
        Userinfo userinfo = userService.getUserDetailsById(userid);
        userinfo.setDescr(descr);
        userinfo.setLink(link);
        int i = userService.updateUserInfo(userinfo);
        if(i == 0){
            return RespBean.error("修改失败");
        }

        return RespBean.ok("修改成功");
    }

    @RequestMapping("/updatePassword")
    public RespBean updatePassword(String userid,String pass){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseridEqualTo(userid);

        User user = userService.getUser(userExample);
        user.setPwd(pass);
        int i = userService.updatePassword(user);
        if(i == 0){
            return RespBean.error("修改失败");
        }

        return RespBean.ok("修改成功");

    }



}
