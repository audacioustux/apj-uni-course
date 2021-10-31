package com.audacioustux.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.*;

import com.audacioustux.util.Cookies;

public class LogoutController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Cookies.deleteAll(req, res);
        req.getSession().invalidate();
        res.sendRedirect("/login");
    }
}
