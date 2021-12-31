package com.example.spring.listBindingExample;

import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 12/10/2021
 * Time: 4:34 PM
 **/


public interface BookService {
    List<Book> findAll();

    void saveAll(List<Book> books);
}
