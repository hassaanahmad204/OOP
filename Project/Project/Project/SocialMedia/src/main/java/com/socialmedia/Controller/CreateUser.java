package com.socialmedia.Controller;

import com.socialmedia.Model.Database;
import com.socialmedia.Model.User;
import com.socialmedia.View.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CreateUser {
    private User user;
    private Database database;

    public CreateUser(User user, Database database){
        this.user = user;
        this.database = database;
    }

    public void create() {
        String insert = "INSERT INTO `users`(`FirstName`, `LastName`, `Email`, "
                + "`Password`) VALUES ('"+user.getFirstName()+"','"+user.getLastName()
                +"','"+user.getEmail()+"','"+user.getPassword()+"');";
        try {
            database.getStatement().execute(insert);
        } catch (SQLException e) {
            new Alert(e.getMessage(), null);
        }
    }
    public boolean isEmailUsed() {
        String select = "SELECT * FROM `users` WHERE `Email` = '"+user.getEmail()+"';";
        boolean used = false;
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            used = rs.next();
        } catch (SQLException e) {
            new Alert(e.getMessage(), null);
        }
        return used;
    }

    public User getUser() {
        user.setFriends(new ArrayList<>());
        user.setComments(new ArrayList<>());
        user.setPosts(new ArrayList<>());
        String select = "SELECT `ID` FROM `users` WHERE `Email` = '"+user.getEmail()+"' AND `Password` = '"+user.getPassword()+"';";
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            rs.next();
            user.setId(rs.getInt("ID"));
        } catch (SQLException e) {
            new Alert(e.getMessage(), null);
        }
        return user;
    }
}
