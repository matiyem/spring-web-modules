package com.example.resttemplate.json.consumer.service;

import java.util.List;

/*
    Create by Atiye Mousavi 
    Date: 5/15/2022
    Time: 2:28 PM
**/
public interface UserConsumerService {

    List<String> processUserDataFromObjectArray();

    List<String> processUserDataFromUserArray();

    List<String> processUserDataFromUserList();

    List<String> processNestedUserDataFromUserArray();

    List<String> processNestedUserDataFromUserList();
}
