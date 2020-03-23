package com.mycompany.app.Service;

//import com.mycompany.app.DAO.UserJdbcDao;
import com.mycompany.app.model.User;
import com.mycompany.app.utils.DbUtils;
import com.mycompany.app.DAO.UserHibernateDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserService {

    private static UserService userService;

    private UserHibernateDao userDao;

    public UserService() {
        userDao = new UserHibernateDao();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }


    public void addUser(String name, String basic_language) {
        User user =  new User(name, basic_language);
        userDao.addUser(user);
    }

    public boolean editUser(long id, String new_name, String new_basic_language) {
        userDao.editUser(id, new_name, new_basic_language);
        return true;
    }

    public User getUserById(long id) throws SQLException {
        return userDao.getUserById(id);
    }
/*
    public void createTable() {
        UserJdbcDao dao = DbUtils.getUserDAO();
        try {
            dao.createTable();
        } catch (SQLException e) {
            System.out.println("Error create table");
        }
    }
*/
    public void deleteUserById(long id) {
        userDao.deleteUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
//        List<User> listAllUsers = new LinkedList<>();
        List<User> listAllUsers = userDao.getAllUsers();
        return listAllUsers;
    }
}
