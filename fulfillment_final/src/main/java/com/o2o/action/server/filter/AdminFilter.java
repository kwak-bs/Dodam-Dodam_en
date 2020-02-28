package com.o2o.action.server.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        System.out.println("ManagerFilter for req : " + req.getServletPath() + "," + req.getMethod());

        boolean checkAuth = false;
        // if (req.getMethod().equalsIgnoreCase("get")) {
        // checkAuth = true;
        // }

        if (checkAuth) {
            if (!req.getServletPath().equalsIgnoreCase("/login")) {
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
        }
        chain.doFilter(request, response);
    }

}
