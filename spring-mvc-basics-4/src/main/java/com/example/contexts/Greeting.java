package com.example.contexts;

/*
    Create by Atiye Mousavi 
    Date: 4/25/2022
    Time: 11:57 AM
**/
public class Greeting {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "Greeting [message=" + message + "]";
    }
}
