package com.coderbd.firebaserealdb;

public class User {
    private String userId;
    private String userName;
    private String password;
    private String email;

    public User() {
    }

    public User(String userId, String userName, String password, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
