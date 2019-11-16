package com.sandalen.water.controller;

import com.sandalen.water.bean.RespBean;
import com.sandalen.water.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnAuthController {

    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping("/getUserByToken")
    public RespBean getUserByToken(@RequestHeader(name = "X-Token") String token){
        if(token != null){
            String userId = jwtUtils.getUserId(token);
            return RespBean.ok("成功查询",userId);
        }
        return RespBean.error("查询失败");
    }
}
