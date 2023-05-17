package com.example.toby.ch01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        connectionMaker = new DConnectionMaker();
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        // db connection
        Connection connection = connectionMaker.makeConnection();

        // add user
        PreparedStatement ps = connection.prepareStatement(
            " INSERT INTO users(id, name, password) " + " VALUES (?, ?, ?);");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();

        // connection close
        ps.close();
        connection.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        // db connection
        Connection connection = connectionMaker.makeConnection();

        // get user
        PreparedStatement ps = connection.prepareStatement(
            " SELECT * " + " FROM users WHERE id = ?;");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        // connection close
        rs.close();
        ps.close();
        connection.close();

        return user;
    }

}
