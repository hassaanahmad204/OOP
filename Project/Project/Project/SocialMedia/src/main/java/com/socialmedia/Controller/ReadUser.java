package com.socialmedia.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.socialmedia.Model.Database;
import com.socialmedia.Model.User;
import com.socialmedia.View.Alert;

public class ReadUser {

    private boolean loggedIn;
    private User user;

    public ReadUser(String email, String password, Database database) {
        String select = "SELECT * FROM `users` WHERE `Email` = '"+email+
                "' AND `Password` = '"+password+"';";
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            loggedIn = rs.next();
            if (loggedIn) {
                user = new User();
                user.setId(rs.getInt("ID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
            }
        } catch (SQLException e) {
            new Alert(e.getMessage(), null);
        }
    }

    public boolean loggedIn() {
        return loggedIn;
    }

    public User getUser() {
        return user;
    }

}
