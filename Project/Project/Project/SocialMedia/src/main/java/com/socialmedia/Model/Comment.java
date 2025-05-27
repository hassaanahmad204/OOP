package com.socialmedia.Model;

import com.socialmedia.Model.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comment {
    private int id;
    private String content;
    private User user;
    private LocalDateTime dateTime;

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy");

    public Comment(){}

    public Comment(User user, String content) {
        this.user = user;
        this.content = content;
        dateTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTimeToString() {
        return dateTimeFormatter.format(dateTime);
    }

    public void setDateTimeFromString(String dateTime) {
        this.dateTime = LocalDateTime.parse(dateTime, dateTimeFormatter);
    }

    public String getDateToString() {
        return dateFormatter.format(dateTime);
    }
}
