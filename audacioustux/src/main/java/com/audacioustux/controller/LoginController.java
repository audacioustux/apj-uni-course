package com.audacioustux.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import java.io.*;
import java.sql.*;
import com.audacioustux.model.*;

public class LoginController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("username");
        String rawPassword = req.getParameter("password");
        boolean do_remember = req.getParameter("remember-me") != null;

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Account account = Accounts.authenticate(username, rawPassword);
            Session session = Sessions.insert(account);

            Cookie ck = new Cookie("sid", session.getId().toString());
            ck.setHttpOnly(true);
            ck.setSecure(true);
            if (do_remember)
                ck.setMaxAge(60 * 24 * 60 * 60); // 60 days
            else
                ck.setMaxAge(-1);

            res.addCookie(ck);
            res.sendRedirect("./");
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
    }
}
