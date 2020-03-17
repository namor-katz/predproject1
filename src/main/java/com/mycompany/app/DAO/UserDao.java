package com.mycompany.app.DAO;

import com.mycompany.app.model.User;

import java.sql.*;

public class UserDao {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO user (name, hashPassword) VALUES(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getHash_password());
        int RowsAffected = preparedStatement.executeUpdate();
    }

    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("CREATE table if not exists user (id bigint auto_increment, name varchar(256), hashPassword varchar(256), primary key(id))");
        stmt.close();
    }

    public ResultSet getAllUsers() throws SQLException {
        String sql = "SELECT * FROM user;";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        return rs;
    }
}
