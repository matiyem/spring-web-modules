package com.example.spring.listBindingExample;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * created by Atiye Mousavi
 * Date: 12/10/2021
 * Time: 5:36 PM
 **/

@Service
public class InMemoryBookService implements BookService{
    static Map<Long,Book> booksDB=new HashMap<>();
    @Override
    public List<Book> findAll() {
        return new ArrayList<>(booksDB.values());
    }

    @Override
    public void saveAll(List<Book> books) {
        long nextId=getNextid();
        for (Book book:books){
            if (book.getId() ==0){
                book.setId(nextId++);
            }
        }
        Map<Long, Book> bookMap = books.stream()
                .collect(Collectors.toMap(Book::getId, Function.identity()));

        booksDB.putAll(bookMap);

    }
    private Long getNextid(){
        return booksDB.keySet()
                .stream()
                .mapToLong(value -> value)
                .max()
                .orElse(0) +1;
    }
}
