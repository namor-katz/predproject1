package com.mycompany.app.servlets;


import com.mycompany.app.Service.UserService;
import com.mycompany.app.model.User;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class listAllUserServlet extends HttpServlet{
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserService userService = new UserService();
        List<String> list = userService.getAllUsers();
        req.setAttribute("userNames", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);

    }

}
