package com.sandalen.water.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

public class SecurityUser implements UserDetails {
    private transient User currentUser;
    private transient Userinfo currentUserinfo;
    private transient List<Role> roles;
    private transient String roleCode;

    public User currentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Userinfo getCurrentUserinfo() {
        return currentUserinfo;
    }

    public void setCurrentUserinfo(Userinfo currentUserinfo) {
        this.currentUserinfo = currentUserinfo;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public SecurityUser(){}

    public SecurityUser(User user){
        if(user != null){
            this.currentUser = user;
        }
    }

    public SecurityUser(User user,List<Role> roleList){
        if(user != null){
            this.currentUser = user;
            this.roles = roleList;

            if(!CollectionUtils.isEmpty(roleList)){
                StringJoiner roleCodes = new StringJoiner(",", "[", "]");
                roleList.forEach(e -> roleCodes.add(e.getRoleid()));
                this.roleCode = roleCodes.toString();
            }
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if(!CollectionUtils.isEmpty(this.roles))
        {
            for (Role role : roles){
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return currentUser.getPwd() ;
    }

    @Override
    public String getUsername() {
        return currentUser.getUserid();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
