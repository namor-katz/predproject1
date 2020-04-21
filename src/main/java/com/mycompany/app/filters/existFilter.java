package com.mycompany.app.filters;

import com.mycompany.app.service.UserService;

import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter(
        urlPatterns = {"/admin/*"},
        filterName = "existFilter",
        description = "This is test webFilter"
)
public class existFilter implements javax.servlet.Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String fromReturn = null;

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        String role = (String) session.getAttribute("role");
        if(role.equals("admin")) {
            fromReturn = "/admin";
        }
        else if (role.equals("user") | role.equals("null")) {
            fromReturn = "/user";
        }
        else {
            fromReturn = "/notfound";
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(fromReturn);
        requestDispatcher.forward(req, res);
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
