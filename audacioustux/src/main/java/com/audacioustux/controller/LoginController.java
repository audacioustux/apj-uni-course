package com.audacioustux.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
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
        PrintWriter out = res.getWriter();

        try {
            Account account = Accounts.authenticate(username, rawPassword);
            Session session = Sessions.insert(account);
            String sid = session.getId().toString();

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
            res.sendRedirect("./");
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
    }
}
