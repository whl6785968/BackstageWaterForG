package com.sandalen.water.security.Login;

import com.sandalen.water.bean.SecurityUser;
import com.sandalen.water.bean.Userinfo;
import com.sandalen.water.service.UserForSecurityService;
import com.sandalen.water.service.UserService;
import com.sandalen.water.util.CookieUtils;
import com.sandalen.water.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
//自定义认证处理
public class AdminAutenticationProvider implements AuthenticationProvider {
    @Autowired
    UserForSecurityService userForSecurityService;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;


    public static AdminAutenticationProvider adminAutenticationProvider;

    @PostConstruct
    public void init(){
        adminAutenticationProvider = this;
        adminAutenticationProvider.userForSecurityService = this.userForSecurityService;
        adminAutenticationProvider.jwtUtils = this.jwtUtils;
        adminAutenticationProvider.userService = this.userService;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpServletResponse response = requestAttributes.getResponse();


        String username = (String)authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        User user = (User) adminAutenticationProvider.userForSecurityService.loadUserByUsername(username);

        if(!BCrypt.checkpw(password,user.getPassword())){
            throw new BadCredentialsException("密码错误");
        }

        com.sandalen.water.bean.User user1 = new com.sandalen.water.bean.User();
        user1.setUserid(user.getUsername());
        user1.setPwd(user.getPassword());
        String token = adminAutenticationProvider.jwtUtils.getToken(user1);
        Cookie cookie;
        Cookie[] cookies = request.getCookies();
        cookie = CookieUtils.getCookie(cookies,"X-Token");
        if( cookie == null){
            cookie = new Cookie("X-Token",token);
            cookie.setMaxAge(3600);
            cookie.setPath("/");

        }else {
            cookie.setValue(token);
        }

        response.addCookie(cookie);

        Userinfo userinfo = adminAutenticationProvider.userService.getUserDetailsById(username);
        userinfo.setToken(token);
        adminAutenticationProvider.userService.updateUserDetails(userinfo);
        SecurityUser securityUser = new SecurityUser();
        securityUser.setCurrentUser(user1);
        securityUser.setCurrentUserinfo(userinfo);


        return new UsernamePasswordAuthenticationToken(securityUser,user.getPassword(),user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
