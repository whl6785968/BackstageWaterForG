package com.sandalen.water.security.Filter;

import com.alibaba.fastjson.JSON;
import com.sandalen.water.bean.LoginUser;
import com.sandalen.water.bean.User;
import com.sandalen.water.security.Login.AdminAuthenticationSuccessHandler;
import com.sandalen.water.security.Login.CusAuthenticationManager;
import com.sandalen.water.util.MultiReadHttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

//自定义用户密码校验器
@Component
public class AdminAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
    public AdminAuthenticationProcessingFilter(CusAuthenticationManager cusAuthenticationManager, AdminAuthenticationSuccessHandler adminAuthenticationSuccessHandler) {
        super(new AntPathRequestMatcher("/login","POST"));
        this.setAuthenticationManager(cusAuthenticationManager);
        this.setAuthenticationSuccessHandler(adminAuthenticationSuccessHandler);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException {
        UsernamePasswordAuthenticationToken authRequest;
        MultiReadHttpServletRequest wrappedRequest = new MultiReadHttpServletRequest(request);
        LoginUser user = JSON.parseObject(wrappedRequest.getBodyStringByJson(wrappedRequest), LoginUser.class);

        authRequest = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),null);
        authRequest.setDetails(authenticationDetailsSource.buildDetails(wrappedRequest));

        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
