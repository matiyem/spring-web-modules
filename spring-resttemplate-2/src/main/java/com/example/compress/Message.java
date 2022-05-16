package com.example.compress;

/*
    Create by Atiye Mousavi 
    Date: 5/15/2022
    Time: 2:16 PM
**/
public class Message {

    private String text;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Message {");
        sb.append("text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
