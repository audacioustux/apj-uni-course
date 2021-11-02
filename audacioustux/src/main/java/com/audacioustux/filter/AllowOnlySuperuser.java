package com.audacioustux.filter;

import java.io.IOException;

import com.audacioustux.model.Account;
import com.audacioustux.model.Accounts;

import jakarta.servlet.*;

public class AllowOnlySuperuser implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        Account account = (Account) req.getAttribute("account");
        if (Accounts.is_superuser(account))
            chain.doFilter(req, res);
        else
            throw new ServletException("you're not authorized to access the page");
    }
}
