package com.audacioustux.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;
import java.util.UUID;

import com.audacioustux.model.*;

public class CommentNewController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        UUID blog_id = UUID.fromString(req.getParameter("blog_id"));
        String body = req.getParameter("body");
        Account account = (Account) req.getAttribute("account");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Comments.insert(account, new Blog(blog_id), body, null);
            res.sendRedirect("/blog/" + blog_id);
        } catch (SQLException e) {
            out.println(e.getMessage());
        }
    }
}
