package com.socialmedia.Controller;

import com.socialmedia.Model.Database;
import com.socialmedia.View.Alert;

import java.sql.SQLException;

public class ChangePass {
    private String pass;
    private int Id;
    private Database database;

    public ChangePass(String pass, int id, Database database) {
        this.pass = pass;
        Id = id;
        this.database = database;
    }

    public boolean change(){
        boolean changed = false;
        String update = "UPDATE `users` SET `Password`='"+pass+"' WHERE `ID` = "
                +Id+" ;";
        try{
            database.getStatement().execute(update);
            changed = true;
        } catch (SQLException e) {
            new Alert(e.getMessage(),null);
            changed = false;
        }
        return changed;
    }
}
