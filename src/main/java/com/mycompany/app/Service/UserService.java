package com.mycompany.app.Service;

import com.mycompany.app.DAO.UserDao;
import com.mycompany.app.model.User;
import com.mycompany.app.utils.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserService {
    public boolean addUser(String name, String basic_language) {
        try {
            User user = new User(name, basic_language);
            UserDao dao = DbUtils.getUserDAO();
            dao.addUser(user);
            return true;
        } catch ( SQLException e) {
            System.out.println("проблема с бд.");
            return false;
        }
    }

    public boolean editUser(String password) {
        return false;
    }

    public boolean deleteUser(String name) {
        return false;
    }

    public User getUserByName(String name) {
        User user = new User();
        return user;
    }

    public void createTable() {
        UserDao dao = DbUtils.getUserDAO();
        try {
            dao.createTable();
        } catch (SQLException e) {
            System.out.println("Error create table");
        }
    }

    public boolean deleteUserById(long id) {
        boolean successDelete;
        UserDao dao = DbUtils.getUserDAO();
        try {
            dao.deleteUserById(id);
            successDelete = true;
        } catch (SQLException e) {
            successDelete = false;
        }
        return successDelete;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> listAllUsers = new LinkedList<>();
        UserDao dao = DbUtils.getUserDAO();
        ResultSet rs = dao.getAllUsers();
        while (rs.next()) {
            long id = Long.parseLong(rs.getString("id"));
            String name = rs.getString("name");
            String basic_language = rs.getString("basic_language");
            String time_created = rs.getString("time_created");
            User user = new User(id, name, basic_language, time_created);
            listAllUsers.add(user);
        }
        return listAllUsers;
    }
}
