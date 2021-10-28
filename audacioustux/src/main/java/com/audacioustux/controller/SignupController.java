package com.audacioustux.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.Cookie;
import java.io.*;
import javax.naming.*;
import javax.sql.*;
import java.sql.*;

public class SignupController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        res.sendRedirect("signup.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Context initCtx = null;
        Context envCtx = null;
        DataSource ds = null;

        try {
            initCtx = new InitialContext();
            envCtx = (Context) initCtx.lookup("java:comp/env");
            ds = (DataSource) envCtx.lookup("jdbc/test");
        } catch (Exception ex) {
            out.println("Error while initializing context");
            out.println("<br>");
            out.println(ex.getMessage());
        }

        Connection conn = null;
        PreparedStatement stmt = null;

        boolean isCreated = true;
        String sql = "";

        try {
            sql = "insert into user (firstName, lastName, email , password) values (?, ?, ?, ?)";
            conn = ds.getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.setString(4, password);

            stmt.execute();

        } catch (Exception ex) {
            isCreated = false;
            out.println("Error while connecting database");
            out.println("<br>");
            out.println(ex.getMessage());
        }

        if (isCreated) {
            res.sendRedirect("index.jsp");
        } else {
            out.println("Error while creating...");
        }
    }

}
