package com.example.boot.domain;

/*
    Create by Atiye Mousavi 
    Date: 4/16/2022
    Time: 3:21 PM
**/
public class Bar extends AbstractEntity {
    private int value;

    public Bar(long id) {
        super(id);
    }

    public Bar(long id, int value) {
        super(id);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Bar [value=" + value + ", id=" + id + "]";
    }
}
