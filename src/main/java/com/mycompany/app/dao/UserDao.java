package com.mycompany.app.dao;

import com.mycompany.app.model.User;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public void  addUser(User user) throws SQLException;
    public int deleteUserById(long id) throws SQLException;
    public void editUser(long id, String name, String basic_language) throws SQLException;
    public User getUserById(long id) throws SQLException;
    public List<User> getAllUsers() throws SQLException;
}
