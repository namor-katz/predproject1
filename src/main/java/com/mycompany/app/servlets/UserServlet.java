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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.servlet.annotation.WebServlet;

//@WebServlet("/register")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //должен возвращать страницу хтмл
        System.out.println("RUN servlet");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(req, resp);
//        PrintWriter writer = resp.getWriter();
//        writer.println("Method GET from AddServlet");
/*
        Map<String, Object> pageVariables = createPageVariablesMap(req);

        UserService userService = new UserService();
        try {
            userService.createTable();
        } catch (Exception e) {
            System.out.println("ошибка при создании таблицы!");
        }


        resp.getWriter().println(PageGenerator.getInstance().getPage("registrationPage.html", pageVariables));

 */
//        resp.setContentType("text/html, charset=utf-8");
//        resp.setStatus(200);
    }

    @SneakyThrows   //WTF
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
        Map<String, Object> pageVariables = createPageVariablesMap(req);
        UserService userService = new UserService();
        String name = req.getParameter("name");
        String password = req.getParameter("password");
//        User user = new User(name, password);

        userService.addUser(name, password);

        resp.getWriter().println(PageGenerator.getInstance().getPage("SuccessRegister.html", pageVariables));

         */
        resp.setContentType("text/html; charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());
        pageVariables.put("pathInfo", request.getPathInfo());
        pageVariables.put("sessionId", request.getSession().getId());
        pageVariables.put("parameters", request.getParameterMap().toString());
        return pageVariables;
    }

}
