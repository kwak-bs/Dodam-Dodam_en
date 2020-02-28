package com.o2o.action.server.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/api/1.0/*")
public class APIFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        System.out.println("APIFilter for req : " + req.getServletPath() + "," + req.getMethod() + "," + req.getPathInfo() + "," + req.getServletPath());

        boolean checkAuth = false;
        if (req.getServletPath().equalsIgnoreCase("/api/1.0/login") || req.getServletPath().equalsIgnoreCase("/api/1.0/logout")) {
        } else {
            if (!req.getMethod().equalsIgnoreCase("get")) {
                checkAuth = true;
            }
        }

        if (checkAuth) {
            HttpSession httpSession = req.getSession();
            if (httpSession == null) {
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            }

            String userId = (String) httpSession.getAttribute("userId");
            if (userId == null || userId.length() <= 0) {
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            }

        }
        chain.doFilter(request, response);
    }

}
