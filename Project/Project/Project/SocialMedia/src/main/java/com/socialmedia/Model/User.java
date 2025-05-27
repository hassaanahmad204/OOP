package com.socialmedia.Model;

import java.util.ArrayList;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private ArrayList<User> user;
    private ArrayList<Comment> comments;
    private ArrayList<Post> posts;
    private ArrayList<Integer> likesIDs;
    private ArrayList<Integer> friendsIDs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(){
        likesIDs = new ArrayList<>();
        friendsIDs = new ArrayList<>();
    }

    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Integer> getLikesIDs() {
        return likesIDs;
    }

    public void setLikesIDs(ArrayList<Integer> likesIDs) {
        this.likesIDs = likesIDs;
    }

    public boolean liked(Post p){
        return likesIDs.contains(p.getId());
    }

    public void like(Post p){
        likesIDs.add(p.getId());
    }

    public void dislike(Post p){
        likesIDs.remove((Integer) p.getId());
    }

    public void setFriends(ArrayList<User> friends){
        friendsIDs = new ArrayList<>();
        for (User u:friends){
            friendsIDs.add(u.getId());
        }
    }

    public ArrayList<Integer> getFriendsIDs() {
        return friendsIDs;
    }

    public void setFriendsIDs(ArrayList<Integer> friendsIDs) {
        this.friendsIDs = friendsIDs;
    }

    public boolean isFriend(User u){
        return friendsIDs.contains(u.getId());
    }

    public void addFriend(User u){
        friendsIDs.add(u.getId());
    }

    public void removeFriend(User u) {
        friendsIDs.remove((Integer) u.getId());
    }
}
