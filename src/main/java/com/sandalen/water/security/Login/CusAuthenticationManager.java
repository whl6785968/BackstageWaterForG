package com.sandalen.water.security.Login;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class CusAuthenticationManager implements AuthenticationManager {
    private final AdminAutenticationProvider adminAutenticationProvider;

    public CusAuthenticationManager(AdminAutenticationProvider adminAutenticationProvider){
        this.adminAutenticationProvider = adminAutenticationProvider;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication authenticate = adminAutenticationProvider.authenticate(authentication);
        if(Objects.nonNull(authenticate)){
            return authenticate;
        }
        throw new ProviderNotFoundException("Authentication failed!");
    }
}
