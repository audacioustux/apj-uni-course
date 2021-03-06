package com.audacioustux.controller;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;
import java.util.UUID;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.audacioustux.model.*;

public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException, JWTCreationException {
        String username = req.getParameter("username");
        String rawPassword = req.getParameter("password");
        boolean do_remember = req.getParameter("remember-me") != null;

        res.setContentType("text/html");

        try {
            Account account = Accounts.authenticate(username, rawPassword);
            if (account == null) {
                throw new ServletException("account does not exist");
            }

            UUID session = account.getId();
            String sid = session.toString();

            Algorithm algorithm = Algorithm.HMAC256(System.getenv("SECRET"));
            String token = JWT.create().withClaim("sid", sid).withSubject(account.getId().toString()).sign(algorithm);

            Cookie ck = new Cookie("refresh_token", token);
            ck.setHttpOnly(true);
            ck.setSecure(true);
            if (do_remember)
                ck.setMaxAge(60 * 60 * 24 * 365 * 10); // 10 years, basically never expires
            else
                ck.setMaxAge(-1);

            res.addCookie(ck);
            res.sendRedirect("/");
        } catch (SQLException e) {
            new ServletException(e.getMessage());
        }
    }
}
