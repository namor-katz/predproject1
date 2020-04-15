package com.mycompany.app.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(
        urlPatterns = "/admin/*",
        filterName = "mainFilter",
        description = "This is test webFilter"
)
public class mainFilter implements javax.servlet.Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        String is_admin = String.valueOf((session.getAttribute("is_admin")));
        boolean next_step = Boolean.valueOf(is_admin);
        if(next_step == false) {
            res.sendRedirect("404.jsp");
        }
        else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/admin");
            dispatcher.forward(req, res);
        }
    }

    @Override
    public void destroy() {

    }
}
