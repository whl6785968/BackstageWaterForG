package com.sandalen.water.security.Filter;

import com.sandalen.water.bean.User;
import com.sandalen.water.bean.UserExample;
import com.sandalen.water.other.Constant;
import com.sandalen.water.security.Login.AdminAuthenticationEntryPoint;
import com.sandalen.water.service.UserForSecurityService;
import com.sandalen.water.service.UserService;
import com.sandalen.water.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAutenticaitonFilter extends OncePerRequestFilter {
    @Autowired
    AdminAuthenticationEntryPoint adminAuthenticationEntryPoint;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Autowired
    UserForSecurityService userForSecurityService;

//    protected MyAutenticaitonFilter(UserForSecurityService userForSecurityService){
//        this.userForSecurityService = userForSecurityService;
//    }
    public static MyAutenticaitonFilter myAutenticaitonFilter;

    @PostConstruct
    public void init(){
        myAutenticaitonFilter = this;
        myAutenticaitonFilter.jwtUtils = this.jwtUtils;
        myAutenticaitonFilter.userForSecurityService = this.userForSecurityService;
        myAutenticaitonFilter.userService = this.userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(request.getContentType());
        System.out.println(request.getMethod());
//        if(request.getMethod() == "Options"){
//
//        }
        String jwtToekn = request.getHeader(Constant.REQUEST_HEADER);

        try{
            if(!StringUtils.isEmpty(jwtToekn) && !"undefined".equals(jwtToekn)){
                String userId = myAutenticaitonFilter.jwtUtils.getUserId(jwtToekn);
                UserExample userExample = new UserExample();
                UserExample.Criteria criteria = userExample.createCriteria();
                criteria.andUseridEqualTo(userId);
                UserDetails userDetails = myAutenticaitonFilter.userForSecurityService.loadUserByUsername(userId);
                if(userDetails == null){
                    throw new BadCredentialsException("Token错误或者过期，请重新登录");
                }

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
            filterChain.doFilter(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
