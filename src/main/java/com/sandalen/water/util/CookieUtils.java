package com.sandalen.water.util;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie getCookie(Cookie[] cookies,String cname){
        if(cookies != null){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals(cname)){
                    return cookie;
                }
            }
        }
        return null;
    }
}
