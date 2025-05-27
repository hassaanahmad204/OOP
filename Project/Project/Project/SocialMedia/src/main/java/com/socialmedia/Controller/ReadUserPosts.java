package com.socialmedia.Controller;

import com.socialmedia.Model.Database;
import com.socialmedia.Model.Post;
import com.socialmedia.Model.User;
import com.socialmedia.View.Alert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReadUserPosts {

    private ArrayList<Post> posts;

    public ReadUserPosts(User u, Database database) {
        posts = new ArrayList<>();
        String select = "SELECT * FROM `posts` WHERE `User` = "+u.getId()+" ;";
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("ID"));
                p.setContent(rs.getString("Content"));
                p.setDateTimeFromString(rs.getString("DateTime"));
                p.setUser(u);
                posts.add(p);
            }
        } catch (SQLException e) {
            new Alert(e.getMessage(), null);
        }
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

}
