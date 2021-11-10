package com.audacioustux.controller;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.*;
import java.sql.*;
import java.util.UUID;
import com.audacioustux.model.*;

public class DeleteAccountController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Accounts.deleteById(UUID.fromString(req.getParameter("account_id")));
        } catch (SQLException e) {
            throw new ServletException("can't delete");
        }
        res.sendRedirect("/");
    }
}
