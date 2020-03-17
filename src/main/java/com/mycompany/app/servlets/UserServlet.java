package com.mycompany.app.servlets;

//import javax.servlet.HttpServlet;
import com.mycompany.app.Service.UserService;
import com.mycompany.app.model.User;
import com.mycompany.app.utils.PageGenerator;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.annotation.WebServlet;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //должен возвращать страницу хтмл
        UserService userService = new UserService();
        userService.createTable();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @SneakyThrows   //WTF
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        userService.addUser(name, password);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
