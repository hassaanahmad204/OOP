package com.socialmedia.Controller;

import com.socialmedia.Model.Database;
import com.socialmedia.Model.User;
import com.socialmedia.View.Alert;

import java.sql.SQLException;

public class UpdateUser {
    private User user;
    private Database database;

    public UpdateUser(User user, Database database){
        this.user = user;
        this.database = database;
    }

    public boolean isEmailUsed(){
        return new CreateUser(user, database).isEmailUsed();
    }

    public boolean update(){
        boolean updated = false;
        String update = "UPDATE `users` SET `FirstName`='" + user.getFirstName() +
                "', `LastName`='" + user.getLastName() +
                "', `Email`='" + user.getEmail() +
                "' WHERE `ID` = " + user.getId() + ";";
        try {
            database.getStatement().execute(update);
            updated = true;
        } catch (SQLException e) {
            new Alert(e.getMessage(), null);
            updated = false;
        }
        return updated;
    }
}
