package com.sandalen.water.security;

import com.sandalen.water.bean.Menu;
import com.sandalen.water.bean.Role;
import com.sandalen.water.dao.MenuMapper;
import com.sandalen.water.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;

@Component
public class UrlFilterInvocationSecurityMetadatasource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    ApplicationContext applicationContext;

//    applicationContext.getBean("menuService")

    @Autowired
    protected MenuService menuService;

    public static UrlFilterInvocationSecurityMetadatasource urlFilterInvocationSecurityMetadatasource;
    @PostConstruct
    public void init(){
        urlFilterInvocationSecurityMetadatasource = this;
        urlFilterInvocationSecurityMetadatasource.menuService = this.menuService;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println("request url is " + requestUrl);
        List<Menu> allMenu = urlFilterInvocationSecurityMetadatasource.menuService.getAllMenu();
        for (Menu menu:allMenu){
            if(antPathMatcher.match(menu.getUrl(),requestUrl)){
                List<Role> roles = menu.getRoles();
                String[] roleArr = new String[roles.size()];
                for(int i=0;i<roleArr.length;i++){
                    roleArr[i] = roles.get(i).getRoleName();
                }
                return SecurityConfig.createList(roleArr);
            }
        }

        return SecurityConfig.createList("ROLE_VISITOR");

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
