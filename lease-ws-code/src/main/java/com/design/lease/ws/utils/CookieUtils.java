package com.design.lease.ws.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {

    public static Cookie getCookie(String name, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length >0){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }

    public static void putCookie(Cookie cookie,HttpServletResponse response){
        response.addCookie(cookie);
    }

}
