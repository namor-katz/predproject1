package com.mycompany.app.Service;

import com.mycompany.app.DAO.UserDao;
import com.mycompany.app.model.User;
import com.mycompany.app.utils.DbUtils;
import com.mycompany.app.utils.Utils;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserService {
    //принять имя юзера и пароль. хэшировать пароль. записать объект юзер в базу.
    public boolean addUser(String name, String password) {
        try {
            //String hashPassword = Utils.HashPassword(password); //тут еще непонятный эксцепшен
            User user = new User(name, password);   //в конструктор передаем пароль. он хэшируется в классе User
            UserDao dao = DbUtils.getUserDAO();
            dao.addUser(user);
            return true;
        } catch ( SQLException | NoSuchAlgorithmException e) {
            System.out.println("проблема с методом хэширования");
            System.out.println("а может с сикуелем. хз кароч.");
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

    public boolean checkPassword(User user) {

        return false;
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

    public List<User> getAllUsers() throws SQLException, NoSuchAlgorithmException {
        List<User> listAllUsers = new LinkedList<>();
        UserDao dao = DbUtils.getUserDAO();
        ResultSet rs = dao.getAllUsers();
        while (rs.next()) {
            long id = Long.parseLong(rs.getString("id"));
            String name = rs.getString("name");
            String datetime = rs.getString("time_created");
            User user = new User(id, name);
            System.out.println(user.getId() + " " + user.getName());
            listAllUsers.add(user);
        }
        return listAllUsers;
    }
}
