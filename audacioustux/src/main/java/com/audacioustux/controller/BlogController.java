package com.audacioustux.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;
import java.util.UUID;

import com.audacioustux.model.*;

public class BlogController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String URI = req.getRequestURI();
        UUID blog_id = UUID.fromString(URI.substring(URI.lastIndexOf("/") + 1, URI.length()));

        try {
            Blog blog = Blogs.get(blog_id);
            Accounts.load(blog.getAccount());

            req.setAttribute("blog", blog);
        } catch (SQLException e) {
            throw new ServletException(e.getMessage());
        }

        req.getRequestDispatcher("/blog.jsp").forward(req, res);
    }
}
