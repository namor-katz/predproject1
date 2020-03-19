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

    public boolean editUser(long id, String new_name, String new_basic_language) throws SQLException {
        User user = new User(new_name, new_basic_language);
        UserDao dao = DbUtils.getUserDAO();
        dao.editUser(id, new_name, new_basic_language);
        return true;
    }

    public User getUserById(long id) throws SQLException {
        UserDao dao = DbUtils.getUserDAO();
        ResultSet res = dao.getUserById(id);
        res.next();
        String name = res.getString("name");
        String basic_language = res.getString("basic_language");
        User user = new User(id, name, basic_language);
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
