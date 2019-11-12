//package com.sandalen.water.config;
//
//import com.sandalen.water.Fileter.CorsFilter;
//import com.sandalen.water.service.UserForSecurityService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.access.channel.ChannelProcessingFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecuriyConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserForSecurityService userService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class).
//                authorizeRequests().antMatchers("/#/authControl").hasRole("ADMIN")
//                .antMatchers("/#/menuConfig").hasRole("ADMIN").anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("http://localhost:8080/#/login")
//                .loginProcessingUrl("/user/login")
//                .successForwardUrl("http://localhost:8080/").permitAll()
//                .and()
//                .csrf().disable();
//
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//}
