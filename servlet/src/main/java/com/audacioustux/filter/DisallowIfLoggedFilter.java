package com.audacioustux.filter;

import java.io.IOException;

import com.audacioustux.model.Account;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DisallowIfLoggedFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        Account account = (Account) req.getAttribute("account");
        if (account != null)
            ((HttpServletResponse) res).sendRedirect("/");
        else
            chain.doFilter(req, res);
    }
}
