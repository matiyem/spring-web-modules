package com.example.service;

import com.example.model.User;
import org.springframework.stereotype.Service;

/*
    Create by Atiye Mousavi 
    Date: 4/10/2022
    Time: 12:26 PM
**/
@Service
public class UserService {
    public User fetchUserByFirstName(String firstName) {
        return new User(1, firstName, "Everyperson");
    }

    public User exampleUser() {
        return new User(1, "Example", "Everyperson");
    }

}
