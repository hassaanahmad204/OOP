package com.socialmedia.Controller;

import com.socialmedia.Model.Database;
import com.socialmedia.Model.Post;
import com.socialmedia.View.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadPostByID {

    private Post post;

    public ReadPostByID(int ID, Database database) {
        String select = "SELECT * FROM `posts` WHERE `ID` = "+ID+" ;";
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            rs.next();
            post = new Post();
            post.setId(ID);
            post.setContent(rs.getString("Content"));
            post.setDateTimeFromString(rs.getString("DateTime"));
            post.setUser(new ReadUserByID(rs.getInt("User"), database).getUser());
        } catch (SQLException e) {
            new Alert(e.getMessage(), null);
        }
    }

    public Post getPost() {
        return post;
    }

}
