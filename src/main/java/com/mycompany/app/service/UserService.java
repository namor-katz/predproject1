package com.mycompany.app.service;

import com.mycompany.app.dao.UserDao;
import com.mycompany.app.dao.UserDaoFactory;
import com.mycompany.app.model.User;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private static UserService userService;

    private UserDao userDao;

    public UserService() {
        userDao = UserDaoFactory.getUserDAO();
    }

    public static UserService getInstance()  {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }


    public void addUser(String name, String password, String basic_language, String role) throws SQLException {
        User user =  new User(name, password, basic_language, role);
        userDao.addUser(user);
    }

    public boolean editUser(long id, String new_name, String new_basic_language) throws SQLException {
        userDao.editUser(id, new_name, new_basic_language);
        return true;
    }

    public void createTable() throws SQLException {
        userDao.createTable();
    }

    public User getUserById(long id) throws SQLException {
        return userDao.getUserById(id);
    }

    public void deleteUserById(long id) throws SQLException {
        userDao.deleteUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> listAllUsers = userDao.getAllUsers();
        return listAllUsers;
    }

    public boolean ifUserExist(String name, String password) throws SQLException {
        return userDao.ifUserExist(name, password);
    }

    public boolean ifUserAdmin(String name, String password) {
        String role = userDao.ifUserAdmin(name, password);
        if(role.equals("admin")) {
            return true;
        }
        else {
            return false;
        }
    }


    public User getUserByName(String name, String password) throws SQLException {
        String separate = "; ";
        return userDao.getUserByName(name, password);
    }
}
