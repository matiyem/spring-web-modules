package com.example.customValidator;

/*
    Create by Atiye Mousavi 
    Date: 5/1/2022
    Time: 10:03 AM
**/
public class ValidatedPhone {

    @ContactNumberConstraint
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return phone;
    }
}
