package com.example.transfer;

/*
    created by Atiye Mousavi
    Date: 5/4/2022
    Time: 3:29 PM
*/


public class LoginForm {
    private String username;
    private String password;

    public LoginForm() {
    }

    public LoginForm(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
