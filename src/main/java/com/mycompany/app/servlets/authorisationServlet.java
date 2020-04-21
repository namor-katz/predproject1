package com.mycompany.app.servlets;

import com.mycompany.app.model.User;
import com.mycompany.app.service.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
        String role = null;
        UserService userService = UserService.getInstance();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        try {
            role = userService.getRoleByName(name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        session.setAttribute("password", password);
        session.setAttribute("role", role);
        resp.sendRedirect("/my_app_war/admin");
    }
}
