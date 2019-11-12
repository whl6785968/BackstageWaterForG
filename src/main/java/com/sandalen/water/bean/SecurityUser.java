package com.sandalen.water.bean;

import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.StringJoiner;

public class SecurityUser{
    private transient User currentUserInfo;
    private transient List<Role> roles;
    private transient String roleCode;

    public SecurityUser(){}

    public SecurityUser(User user){
        if(user != null){
            this.currentUserInfo = user;
        }
    }

    public SecurityUser(User user,List<Role> roleList){
        if(user != null){
            this.currentUserInfo = user;
            this.roles = roleList;

            if(!CollectionUtils.isEmpty(roleList)){
                StringJoiner roleCodes = new StringJoiner(",", "[", "]");
                roleList.forEach(e -> roleCodes.add(e.getRoleid()));
                this.roleCode = roleCodes.toString();
            }
        }
    }


}
