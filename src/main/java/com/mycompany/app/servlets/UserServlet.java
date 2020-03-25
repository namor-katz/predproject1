package com.mycompany.app.servlets;

import com.mycompany.app.service.UserService;
import lombok.SneakyThrows;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add", name = "UserServlet")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        UserService userService = new UserService();
//        userService.createTable();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/my_app_war/list";
        UserService userService = new UserService();
        String name = req.getParameter("name");
        String basic_language = req.getParameter("lang");
        userService.addUser(name, basic_language);

        resp.sendRedirect(path);
    }
}
