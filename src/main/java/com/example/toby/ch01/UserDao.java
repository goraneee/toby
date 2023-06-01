package com.example.toby.ch01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class UserDao {

    private ConnectionMaker connectionMaker;

    private Connection c;

    private User user;

    public UserDao() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        this.connectionMaker = context.getBean("connectionMaker", ConnectionMaker.class);
    }

    public User get(String id) throws ClassNotFoundException, SQLException {

        this.c = connectionMaker.makeConnection();

        // get user
        PreparedStatement ps = c.prepareStatement(
            " SELECT * " + " FROM users WHERE id = ?;");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        this.user = new User();
        this.user.setId(rs.getString("id"));
        this.user.setName(rs.getString("name"));
        this.user.setPassword(rs.getString("password"));
        rs.close();
        ps.close();
        c.close();
        return this.user;
    }

}