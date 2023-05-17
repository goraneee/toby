package com.example.toby.ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

     public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/tobispring", "root", "4250");
         return connection;
     }
}
