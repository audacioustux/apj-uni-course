package com.audacioustux.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import com.audacioustux.model.Account;
import com.audacioustux.model.Accounts;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AuthenticateFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        Cookie[] cookies = ((HttpServletRequest) req).getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();

                if (cookieName.equals("refresh_token")) {
                    Algorithm algorithm = Algorithm.HMAC256(System.getenv("SECRET"));
                    JWTVerifier verifier = JWT.require(algorithm).build();

                    req.setAttribute("account", null);
                    try {
                        DecodedJWT jwt = verifier.verify(cookieValue);
                        UUID acc_id = UUID.fromString(jwt.getSubject());
                        Account account = Accounts.load(new Account(acc_id));
                        if (account != null) {
                            req.setAttribute("account", account);
                        }
                    } catch (SQLException e) {
                        throw new ServletException(e.getMessage());
                    }
                }
            }
        }

        chain.doFilter(req, res);
    }
}
