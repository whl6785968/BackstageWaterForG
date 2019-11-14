package com.sandalen.water.security.Login;

import com.sandalen.water.bean.RespBean;
import com.sandalen.water.bean.SecurityUser;
import com.sandalen.water.bean.Userinfo;
import com.sandalen.water.service.UserService;
import com.sandalen.water.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AdminAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        SecurityUser securityUser =  (SecurityUser)authentication.getPrincipal();
        Userinfo userinfo = securityUser.getCurrentUserinfo();

        ResponseUtils.out(httpServletResponse, RespBean.ok("登录成功",userinfo));
    }
}
