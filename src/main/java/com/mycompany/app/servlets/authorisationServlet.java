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
import java.io.FileNotFoundException;
import java.io.IOException;

@WebServlet(urlPatterns = "", name="authorisationServlet")
public class authorisationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String path = "/my_app/";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String successAdminPath = "/my_app/";   //list
        String successUserPath = "/my_app/";    //user info
        String userNotExistPath = "";   //отдать страницу 404 or userNotFound
        String fromReturn = null;
        boolean isUserExist;
        boolean isUserAdmin;

        UserService userService = new UserService();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        isUserExist = userService.ifUserExist(name, password);
        isUserAdmin = userService.ifUserAdmin(name, password);
        User user = userService.getUserByName(name, password);

        if(isUserExist & isUserAdmin) {
            fromReturn = "/my_app_war/list";
            System.out.println("Я тут, но где же переход?");

        }
        else if (isUserExist) {
            fromReturn = "/my_app_war/list"; //getuser by name
            req.setAttribute("user", user.toString());  //single simple user jsp
        }
        else {
            fromReturn = ""; //return 404
        }

        resp.sendRedirect(fromReturn);

    }
}
