package com.example.spring.listBindingExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Atiye Mousavi
 * Date: 12/10/2021
 * Time: 5:51 PM
 **/

@Controller
@RequestMapping("/books")
public class MultipleBooksController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/all")
    public String showAll(Model model){
        model.addAttribute("books",bookService.findAll());
        return "allBooks";
    }
    @GetMapping(value = "/create")
    public String showCreateFrom(Model model){
        BooksCreationDto booksFrom=new BooksCreationDto();
        for (int i=1 ; i<=3 ; i++){
            booksFrom.addBook(new Book());
        }
        model.addAttribute("form",booksFrom);
        return "createBooksForm";
    }
    @GetMapping(value = "/edit")
    public String showEditForm(Model model){
        List<Book> books=new ArrayList<>();
        bookService.findAll().iterator().forEachRemaining(books::add);
        model.addAttribute("form",new BooksCreationDto(books));
        return "editBooksForm";
    }
    @PostMapping(value = "/save")
    public String saveBooks(@ModelAttribute BooksCreationDto form,Model model){
        bookService.saveAll(form.getBooks());
        model.addAttribute("books",bookService.findAll());
        return "redirect:/books/all";
    }

}
