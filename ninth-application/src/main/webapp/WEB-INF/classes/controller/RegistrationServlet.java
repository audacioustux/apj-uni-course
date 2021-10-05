package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import java.io.*;

import model.*;

public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String loginId = req.getParameter("loginId");
        String password = req.getParameter("password");

        UserUtil util = new UserUtil();
        util.insert(loginId, password);

        /*
         * RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
         * req.setAttribute("message", "success"); dispatcher.forward(req, resp);
         */

        resp.sendRedirect("registration.jsp?message='success'");
    }
}
