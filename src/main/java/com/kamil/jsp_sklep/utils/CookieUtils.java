package com.kamil.jsp_sklep.utils;

import com.kamil.jsp_sklep.models.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    public static void createUserCookie(HttpServletResponse response, User user) {
        Cookie cookie = new Cookie("user",user.getUsername());
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);
    }
}
