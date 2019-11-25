package com.sandalen.water.config;

import com.sandalen.water.Filter.CorsFilter;
import com.sandalen.water.security.CustomAccessDecisioManager;
import com.sandalen.water.security.Filter.AdminAuthenticationProcessingFilter;
import com.sandalen.water.security.Filter.MyAutenticaitonFilter;
import com.sandalen.water.security.Login.AdminAutenticationProvider;
import com.sandalen.water.security.Login.AdminAuthenticationEntryPoint;
import com.sandalen.water.security.Login.AdminAuthenticationSuccessHandler;
import com.sandalen.water.security.Login.CusAuthenticationManager;
import com.sandalen.water.security.UrlFilterInvocationSecurityMetadatasource;
import com.sandalen.water.service.UserForSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecuriyConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserForSecurityService userService;

    //访问鉴权 - 认证token
    private final MyAutenticaitonFilter myAutenticaitonFilter;

    //访问权限认证异常处理
    private final AdminAuthenticationEntryPoint adminAuthenticationEntryPoint;

    //用户密码校验器
    private final AdminAuthenticationProcessingFilter adminAuthenticationProcessingFilter;

    public SecuriyConfig(MyAutenticaitonFilter myAutenticaitonFilter,AdminAuthenticationEntryPoint adminAuthenticationEntryPoint,AdminAuthenticationProcessingFilter adminAuthenticationProcessingFilter){
        this.myAutenticaitonFilter = myAutenticaitonFilter;
        this.adminAuthenticationEntryPoint = adminAuthenticationEntryPoint;
        this.adminAuthenticationProcessingFilter = adminAuthenticationProcessingFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        AdminAutenticationProvider provider = new AdminAutenticationProvider();
        http.cors().and().csrf().disable().authorizeRequests().antMatchers("/ws/**").permitAll()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
        @Override
        public <O extends FilterSecurityInterceptor> O postProcess(O o) {
            o.setSecurityMetadataSource(new UrlFilterInvocationSecurityMetadatasource());
            o.setAccessDecisionManager(new CustomAccessDecisioManager());
            return o;
        }
    }).antMatchers("/login").permitAll().and().addFilterAt(new AdminAuthenticationProcessingFilter(new CusAuthenticationManager(provider),new AdminAuthenticationSuccessHandler()),UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new MyAutenticaitonFilter(),BasicAuthenticationFilter.class);
        http.addFilterBefore(new CorsFilter(),ChannelProcessingFilter.class);


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    RoleHierarchy roleHierarchy(){
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierachy = "ROLE_ADMIN > ROLE_CLIENT > ROLE_VISITOR";
        roleHierarchy.setHierarchy(hierachy);
        return roleHierarchy;
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("index.html","/static/**","/favicon.ico","/login_page","/ws/**");
    }
}
