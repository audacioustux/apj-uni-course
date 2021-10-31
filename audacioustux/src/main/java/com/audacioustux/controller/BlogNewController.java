package com.audacioustux.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;
import com.audacioustux.model.*;

public class BlogNewController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/blogs/new.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String title = req.getParameter("title");
        String body = req.getParameter("body");
        Account account = (Account) req.getAttribute("account");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Blog blog = Blogs.insert(account, title, body);
            res.sendRedirect("/blog/" + blog.getId());
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
    }
}
