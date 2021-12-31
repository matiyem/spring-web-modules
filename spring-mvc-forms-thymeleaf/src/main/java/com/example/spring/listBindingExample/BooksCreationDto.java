package com.example.spring.listBindingExample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 12/10/2021
 * Time: 4:33 PM
 **/

@Data
@AllArgsConstructor
public class BooksCreationDto {
    private List<Book> books;
    public BooksCreationDto() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

}
