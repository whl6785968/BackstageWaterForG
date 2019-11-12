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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/getUserByToken")
    public RespBean getUserByToken(String token){
        if(token != null){
            String userId = jwtUtils.getUserId(token);
            return RespBean.ok("成功查询",userId);
        }
        return RespBean.error("查询失败");
    }

    @RequestMapping("/login")
    public RespBean login(@RequestBody LoginUser loginUser, HttpServletRequest request, HttpServletResponse response){
        System.out.println("dengdeng");
        Cookie cookie;
        JSONObject jsonObject = new JSONObject();
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUseridEqualTo(loginUser.getUsername());
        User user1 = userService.getUser(userExample);
        if(user1 == null){
            return RespBean.error("该用户不存在");
        }
        else {
            if(!loginUser.getPassword().equals(user1.getPwd())){
                return RespBean.error("密码错误");
            }
            else {
                String token = jwtUtils.getToken(user1);
                Cookie[] cookies = request.getCookies();
                cookie = CookieUtils.getCookie(cookies, "X-Token");
                if(cookie != null){
                    cookie.setValue(token);
                }
                else {
                    cookie = new Cookie("X-Token",token);
                    cookie.setMaxAge(36000);
                    cookie.setPath("/");
                }
                response.addCookie(cookie);
                jsonObject.put("token",token);
                jsonObject.put("user",user1);

                return RespBean.ok("登录成功",jsonObject);
            }
        }

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
        Role role = userService.getRoleById(userid);
        if(role == null){
            return RespBean.error("获取角色失败");
        }

        return RespBean.ok("获取成功",role);
    }
}
