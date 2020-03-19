package com.mycompany.app.servlets;

import com.mycompany.app.Service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete", name = "deleteUserServlet")
public class deleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = "/my_app_war/list";
        long id = Long.parseLong(req.getParameter("id"));
        UserService userService = new UserService();
        userService.deleteUserById(id);

       resp.sendRedirect(path);
    }
}
