package com.mycompany.app.servlets;

import com.mycompany.app.model.User;
import com.mycompany.app.service.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/user", name = "singleUserServlet")
public class singleUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = null;
        try {
            user = userService.getUserByName(name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("user", user);
        RequestDispatcher rd = req.getRequestDispatcher("detail.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("УРРРЯ!");
    }
}
