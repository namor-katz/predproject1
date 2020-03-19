package com.mycompany.app.servlets;

import com.mycompany.app.Service.UserService;
import com.mycompany.app.model.User;
import lombok.SneakyThrows;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/list", name = "listAllUserServlet")
public class listAllUserServlet extends HttpServlet{
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getServletPath();

        try {
            switch (action) {
                case "/list/edit":
                    editUser(req, resp);
                    break;
                case "/my_app_war/delete":
                    deleteUser(req, resp);
                case "/delete":
                    deleteUser(req, resp);
                default:
                    listUser(req, resp);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        UserService userService = new UserService();
        List<User> list = userService.getAllUsers();
        req.setAttribute("userNames", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String idStr = req.getParameter("id");
        Long id = Long.parseLong(idStr);
        userService.deleteUserById(id);
        resp.sendRedirect("list");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
//        requestDispatcher.forward(req, resp);
    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("fff");
    }
}
