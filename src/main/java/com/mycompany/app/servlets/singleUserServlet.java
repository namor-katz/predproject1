package com.mycompany.app.servlets;

import com.mycompany.app.model.User;
import com.mycompany.app.service.UserService;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditor;
import java.io.IOException;

@WebServlet(urlPatterns = "/detail", name = "singleUserServlet")
public class singleUserServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = userService.getUserByName(name, password);
        req.setAttribute("user", user);
        RequestDispatcher rd = req.getRequestDispatcher("detail.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("УРРРЯ!");
    }
}
