package com.mycompany.app.servlets;

import com.mycompany.app.service.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/add", name = "UserServlet")
public class UserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserService userService = new UserService();
        try {
            userService.createTable();
        } catch (SQLException e) {
            System.out.println("this SQLException");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/my_app_war";
        UserService userService = new UserService();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String basic_language = req.getParameter("lang");
        String role = String.valueOf(req.getParameter("role"));
        try {
            userService.addUser(name, password, basic_language, role);
        } catch (SQLException e) {
            System.out.println("This is SQLExceptions of UserServlet.doPost");
        }

        resp.sendRedirect(path);
    }
}
