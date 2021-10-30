package com.audacioustux.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import com.audacioustux.model.Accounts;
import com.audacioustux.model.Session;
import com.audacioustux.model.Sessions;
import com.audacioustux.util.MD5;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class AuthenticateFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException, JWTVerificationException {

        Cookie[] cookies = ((HttpServletRequest) req).getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();

                if (cookieName.equals("refresh_token")) {
                    Algorithm algorithm = Algorithm.HMAC256(System.getenv("SECRET"));
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT jwt = verifier.verify(cookieValue);

                    try {
                        Session session = Sessions.get(UUID.fromString(jwt.getClaim("sid").asString()));

                        if (session != null) {
                            req.setAttribute("account", Accounts.load(session.getAccount()));
                        } else
                            req.setAttribute("account", null);
                    } catch (SQLException e) {
                        throw new ServletException("hmm.. problem... figureitoutyoself :/");
                    }
                }
            }
        }

        chain.doFilter(req, res);
    }
}
