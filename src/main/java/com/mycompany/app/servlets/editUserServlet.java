package com.mycompany.app.servlets;

import com.mycompany.app.service.UserService;
import com.mycompany.app.model.User;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit", name="editServlet")
public class editUserServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = "/my_app_war/edit";
        long id = Long.parseLong(req.getParameter("id"));
        UserService userService = new UserService();
        User user = userService.getUserById(id);
        req.setAttribute("user", user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String path = "/my_app_war/list";
        UserService userService = new UserService();
        String name = req.getParameter("name");
        String basic_language = req.getParameter("lang");
        long id = Long.parseLong(req.getParameter("id"));
        userService.editUser(id, name, basic_language);

        resp.sendRedirect(path);
    }
}
