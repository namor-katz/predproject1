package com.mycompany.app.servlets;

import com.mycompany.app.service.UserService;
import com.mycompany.app.model.User;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin", name = "listAllUserServlet")
public class listAllUserServlet extends HttpServlet{
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        UserService userService = new UserService();
//        session.getAttribute("is_admin");
        String is_admin = String.valueOf((session.getAttribute("is_admin")));
        boolean nextStep = Boolean.valueOf(is_admin);
        if(nextStep == true) {
            List<User> list = userService.getAllUsers();
            req.setAttribute("userNames", list);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
            requestDispatcher.forward(req, resp);
        }
        else {
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("p404.jsp");
//            requestDispatcher.forward(req, resp);
            resp.sendRedirect("/my_app_war/notfound");
        }
    }
}
