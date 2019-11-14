package com.sandalen.water.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sandalen.water.bean.User;
import com.sandalen.water.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtUtils {

    public String getToken(User user){
        String token = "";
        token = JWT.create().withAudience(user.getUserid().toString()).sign(Algorithm.HMAC256(user.getPwd()));
        return token;
    }

    public String getUserId(String token){
        DecodedJWT decode = JWT.decode(token);
        List<String> audience = decode.getAudience();

        return audience.get(0);
    }

}
