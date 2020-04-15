package com.mycompany.app.servlets;

import com.mycompany.app.service.UserService;
import com.mycompany.app.model.User;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/admin", name = "listAllUserServlet")
public class listAllUserServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserService userService = new UserService();
        List<User> list = null;
        try {
            list = userService.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("userNames", list);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
            requestDispatcher.forward(req, resp);
    }
}
