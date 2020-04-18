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

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String fromReturn = null;
        boolean isUserExist = false;
        boolean isUserAdmin = false;
        String is_exist = null;

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
//            System.out.println("перенаправление на проверку роли");
            fromReturn = "/my_app_war/admin";
        }
        else if (isUserExist) {
            fromReturn = "/my_app_war/user";
        }
        else {
            fromReturn = "/my_app_war/notfound";
            //this user not found!
        }

        res.sendRedirect(fromReturn);
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
