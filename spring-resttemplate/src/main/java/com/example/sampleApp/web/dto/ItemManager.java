package com.example.sampleApp.web.dto;

/*
    created by Atiye Mousavi
    Date: 5/4/2022
    Time: 2:11 PM
*/


public class ItemManager {
    public static Item getById(final int id) {
        final Item item = new Item(2, "book", "John");
        return item;
    }
}
