package com.sandalen.water.security.Login;


import com.sandalen.water.bean.RespBean;
import com.sandalen.water.util.ResponseUtils;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AdminAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        RespBean respBean;

        if(e instanceof UsernameNotFoundException || e instanceof BadCredentialsException){
            respBean = RespBean.error(e.getMessage());
        }
        else if(e instanceof LockedException){
            respBean = RespBean.error("用户被锁定");
        }
        else if(e instanceof CredentialsExpiredException){
            respBean = RespBean.error("证书过期");
        }
        else if(e instanceof AccountExpiredException){
            respBean = RespBean.error("账户过期");
        }
        else if(e instanceof DisabledException){
            respBean = RespBean.error("用户被禁用");
        }
        else {
            respBean = RespBean.error("登录失败");
        }

        ResponseUtils.out(httpServletResponse,respBean);
    }
}
