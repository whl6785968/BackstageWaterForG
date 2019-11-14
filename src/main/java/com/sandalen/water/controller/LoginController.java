package com.sandalen.water.controller;

import com.alibaba.fastjson.JSONObject;
import com.sandalen.water.bean.*;
import com.sandalen.water.service.UserService;
import com.sandalen.water.util.CookieUtils;
import com.sandalen.water.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

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

    @RequestMapping("/getUserByToken")
    public RespBean getUserByToken(@RequestHeader(name = "X-Token") String token){
        if(token != null){
            String userId = jwtUtils.getUserId(token);
            return RespBean.ok("成功查询",userId);
        }
        return RespBean.error("查询失败");
    }

    @RequestMapping("/login_page")
    public RespBean login_page(){


        return RespBean.error("还未登录");
    }
}
