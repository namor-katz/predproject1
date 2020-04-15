package com.mycompany.app.servlets;

import com.mycompany.app.model.User;
import com.mycompany.app.service.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "", name="authorisationServlet")
public class authorisationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fromReturn = null;
        boolean isUserExist = false;
        boolean isUserAdmin = false;

        UserService userService = new UserService();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
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
        HttpSession session = req.getSession();

        if(isUserExist & isUserAdmin) {
            session.setAttribute("is_admin", true);
            fromReturn = "/my_app_war/admin";

        }
        else if (isUserExist) {
            session.setAttribute("is_admin", false);
            req.setAttribute("name", name);  //single simple user jsp
            req.setAttribute("password", password);

            User user = null;
            try {
                user = userService.getUserByName(name, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            req.setAttribute("user", user);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("detail.jsp");
            requestDispatcher.forward(req, resp);
        }
        else {
            session.setAttribute("is_admin", false);
            fromReturn = "/my_app_war/notfound"; //return 404
        }

        resp.sendRedirect(fromReturn);

    }
}
