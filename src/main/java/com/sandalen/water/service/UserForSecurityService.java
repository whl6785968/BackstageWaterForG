//package com.sandalen.water.service;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.sandalen.water.bean.Role;
//import com.sandalen.water.bean.UserRole;
//import com.sandalen.water.bean.UserRoleExample;
//import com.sandalen.water.dao.RoleMapper;
//import com.sandalen.water.dao.UserMapper;
//import com.sandalen.water.dao.UserRoleMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserForSecurityService implements UserDetailsService {
//    @Autowired
//    private UserRoleMapper userRoleMapper;
//
//    @Autowired
//    private RoleMapper roleMapper;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        System.out.println(
//                "security username is " + s
//        );
//        UserRoleExample example = new UserRoleExample();
//        example.createCriteria().andUserIdEqualTo(s);
//        List<UserRole> userRoles = userRoleMapper.selectByExample(example);
//        List<SimpleGrantedAuthority> list = new ArrayList<>();
//
//        com.sandalen.water.bean.User user = userMapper.selectByPrimaryKey(s);
//
//        if(!StringUtils.isEmpty(userRoles)){
//            UserRole userRole = userRoles.get(0);
//            String role_id = userRole.getRoleId();
//            Role role = roleMapper.selectByPrimaryKey(role_id);
//            if(!StringUtils.isEmpty(role)){
//                String roleName = role.getRoleName();
//                list.add(new SimpleGrantedAuthority(roleName.trim()));
//            }
//        }
//        return new User(user.getUserid(),new BCryptPasswordEncoder().encode(user.getPwd()),list);
//    }
//}
