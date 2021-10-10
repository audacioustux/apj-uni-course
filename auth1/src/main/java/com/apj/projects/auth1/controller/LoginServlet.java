package com.apj.projects.auth1.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
// import jakarta.servlet.RequestDispatcher;
import java.io.*;

import com.apj.projects.auth1.model.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        // PrintWriter out = resp.getWriter();

        String loginId = req.getParameter("loginId");
        String password = req.getParameter("password");

        UserUtil util = new UserUtil();
        if (util.isValidUser(loginId, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("loginId", loginId);
            resp.sendRedirect("index.jsp");
        } else {
            resp.sendRedirect("login.jsp");
        }
        /*
         * RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
         * req.setAttribute("message", "success"); dispatcher.forward(req, resp);
         */

    }
}
