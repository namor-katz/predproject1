package com.mycompany.app.dao;

import com.mycompany.app.model.User;
import com.mycompany.app.utils.DBHelper;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserJdbcDao implements UserDao {
    private Connection connection;

    public UserJdbcDao() {
        this.connection = DBHelper.getUserDAO();

    }

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO user (name, basic_language, time_created) VALUES(?, ?, NOW())";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getBasic_language());
        int RowsAffected = preparedStatement.executeUpdate();
    }

    public int deleteUserById(long id) throws SQLException {
        String query = "DELETE FROM user WHERE id = ?";
        PreparedStatement prs = connection.prepareStatement(query);
        prs.setLong(1, id);
        int row = prs.executeUpdate();
        return row;
    }

    public void editUser(long id, String name, String basic_language) throws SQLException {
        String query = "UPDATE user SET  name = ?, basic_language = ? WHERE id = ?";
        PreparedStatement prs = connection.prepareStatement(query);
        prs.setString(1, name);
        prs.setString(2, basic_language);
        prs.setLong(3, id);
        int row = prs.executeUpdate();
    }

    public void createTable() throws SQLException {
        String sqlFromCreateTable = "CREATE table if not exists user (id bigint auto_increment, name varchar(256), " +
                "password varchar(256), is_admin boolean not null default 0, basic_language varchar(256), " +
                "time_created timestamp, primary key(id))";
        Statement stmt = connection.createStatement();
//        stmt.execute("CREATE table if not exists user (id bigint auto_increment, name varchar(256), basic_language varchar(256), time_created timestamp, primary key(id))");
        stmt.execute(sqlFromCreateTable);
        stmt.close();
    }

    public User getUserById(long id) throws SQLException {
        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement prs = connection.prepareStatement(sql);
        prs.setLong(1, id);
        ResultSet rs = prs.executeQuery();
        rs.next();
        String name = rs.getString("name");
        String basic_language = rs.getString("basic_language");
        User user = new User(name, basic_language);
        return user;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> listAllUsers = new LinkedList<>();
        String sql = "SELECT * FROM user;";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

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

    @SneakyThrows
    public boolean ifUserExist(String name, String password)  {
        String sql = "SELECT * FROM user WHERE name = ? and password = ?";
        PreparedStatement prs = connection.prepareStatement(sql);
        prs.setString(1, name);
        prs.setString(2, password);
        ResultSet rs = prs.executeQuery();
        return rs.next();
    }

    @SneakyThrows
    public boolean ifUserAdmin(String name, String password) {
        String sql = "SELECT is_admin FROM user WHERE name = ? and password = ?";
        PreparedStatement prs = connection.prepareStatement(sql);
        prs.setString(1, name);
        prs.setString(2, password);
        ResultSet rs = prs.executeQuery();
        return rs.next();
    }

    @SneakyThrows
    public User getUserByName(String name, String password) {
        String sql = "SELECT * from user WHERE name = ? and password = ?";
        PreparedStatement prs = connection.prepareStatement(sql);
        prs.setString(1, name);
        prs.setString(2, password);
        ResultSet rs = prs.executeQuery();
        rs.next();
        String basic_language = rs.getString("basic_language");
        Long id = rs.getLong("id");
        User user = new User(id, name, basic_language);
        return user;
    }

}
