package com.audacioustux.filter;

import java.io.IOException;
import java.util.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ReqLogFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        String ipAddress = req.getRemoteAddr();
        String protocol = req.getProtocol();
        String method = ((HttpServletRequest) req).getMethod();
        String uri = ((HttpServletRequest) req).getRequestURI();

        System.out.println("[" + new Date().getTime() + "] " + protocol + " " + method + ", " + ipAddress + ", " + uri);

        chain.doFilter(req, res);
    }
}
