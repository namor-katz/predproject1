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
        boolean isUserExist = false;
        boolean isUserAdmin = false;
//        String is_exist = null;

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        UserService userService = new UserService();
        String name = (String) session.getAttribute("name");
        String password = (String)  session.getAttribute("password");

        try {
            isUserExist = userService.ifUserExist(name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            isUserAdmin = userService.ifUserAdmin(name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(isUserExist & isUserAdmin) {
            fromReturn = "/admin";
        }
        else if (isUserExist) {
            fromReturn = "/user";
        }
        else {
            fromReturn = "/notfound";
        }

//        res.sendRedirect(fromReturn);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(fromReturn);
        requestDispatcher.forward(req, res);
//        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
