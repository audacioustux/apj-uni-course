package com.audacioustux.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.*;

public class Cookies {
    public static void deleteAll(HttpServletRequest req, HttpServletResponse res) {
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];

                cookie.setMaxAge(0);
                res.addCookie(cookie);
            }
        }
    }
}
