package com.sandalen.water.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sandalen.water.bean.*;
import com.sandalen.water.customAnnotation.SystemControllerLog;
import com.sandalen.water.service.LogService;
import com.sandalen.water.service.UserService;
import com.sandalen.water.util.JwtUtils;
import com.sandalen.water.util.ObjectUtils;
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

    @Autowired
    private LogService logService;


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

    @RequestMapping("/getAllUser")
    public RespBean getAllUser(int page,int pageSize){
        PageHelper.startPage(page,pageSize);
        List<User> allUser = userService.getAllUser();
        PageInfo<User> pageInfo = new PageInfo<>(allUser);
        return RespBean.ok("success",pageInfo);
    }

    @SystemControllerLog(description = "修改用户信息")
    @RequestMapping("/updateUserInfo")
    public RespBean updateUserInfo(String name,String link,String descr,String avatar,String userid){
        Userinfo userinfo = userService.getUserDetailsById(userid);

        if(!ObjectUtils.isStringEmpty(name)){
            userinfo.setName(name);
        }

        if(!ObjectUtils.isStringEmpty(link)){
            userinfo.setLink(link);
        }

        if(!ObjectUtils.isStringEmpty(descr)){
            userinfo.setDescr(descr);
        }

        if(!ObjectUtils.isStringEmpty(avatar)){
            userinfo.setAvatar(avatar);
        }

        int i = userService.updateUserInfo(userinfo);
        if(i == 0){
            return RespBean.error("修改失败");
        }

        return RespBean.ok("修改成功");
    }

    @SystemControllerLog(description = "修改密码")
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

    @RequestMapping("/updateAvatar")
    public RespBean updateAvatar(){
        return RespBean.ok("success");
    }

    @RequestMapping("/getLog")
    public RespBean getLog(String userid,int page,int pageSize){
        PageHelper.startPage(page,pageSize);
        List<SystemLog> log = logService.getLog(userid);

        PageInfo<SystemLog> systemLogPageInfo = new PageInfo<>(log);

        return RespBean.ok("success",systemLogPageInfo);
    }



}
