
package com.audacioustux.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import com.audacioustux.model.*;

public class BlogsController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            ArrayList<Blog> blogs = Blogs.getAll();

            req.setAttribute("blogs", blogs);
        } catch (SQLException e) {
            throw new ServletException(e.getMessage());
        }

        req.getRequestDispatcher("/blogs/index.jsp").forward(req, res);
    }
}
