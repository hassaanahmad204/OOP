package com.socialmedia.Model;

import com.socialmedia.View.Alert;

import java.sql.*;

public class Database {
    private String user = "root";
    private String pass = "hassaan123";
    private String url = "jdbc:mysql://localhost:3306/socialmedia";
    private Statement statement;

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Add this line to load the driver
            Connection connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (ClassNotFoundException e) {
            new Alert("MySQL Driver not found: " + e.getMessage(), null);
        } catch (SQLException e) {
            new Alert("Database connection error: " + e.getMessage(), null);
        }
    }

    public Statement getStatement() {
        return statement;
    }
}
