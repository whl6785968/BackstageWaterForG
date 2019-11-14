package com.sandalen.water.security.Login;

import com.sandalen.water.bean.RespBean;
import com.sandalen.water.util.ResponseUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//认证权限入口-未登录的情况下访问所有接口都会拦截到此
@Component
public class AdminAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        if(e != null){
            ResponseUtils.out(httpServletResponse, RespBean.expired(e.getMessage()));
        }
        else
        {
            ResponseUtils.out(httpServletResponse,RespBean.error("JWToekn过期"));
        }
    }
}
