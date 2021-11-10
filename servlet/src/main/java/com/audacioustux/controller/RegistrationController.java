package com.audacioustux.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;
import com.audacioustux.model.*;

public class RegistrationController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String rawPassword = req.getParameter("password");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Accounts.insert(username, email, rawPassword);
            res.sendRedirect("/login");
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
    }
}
