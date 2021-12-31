package com.example.spring.sessionAttrs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;

/**
 * Create by Atiye Mousavi
 * Date: 12/11/2021
 * Time: 12:27 PM
 **/
@Controller
@RequestMapping("/sessionattributes")
@SessionAttributes("todos")
public class TodoControllerWithSessionAttributes {
    //این متد وظیفه مقداردهی اولیه فرم و نمایش نمای فرم را بر عهده خواهد داشت. اگر TodoList خالی نباشد، این روش فرم را با جدیدترین TodoItem اضافه شده پر می کند.
    @GetMapping("/form")
    public String shownForm(Model model, @ModelAttribute("todos") TodoList todos){
        if(!todos.isEmpty()){
            model.addAttribute("todo",todos.peekLast());
        }else {
            model.addAttribute("todo",new TodoItem());
        }
        return "sessionattributesform";
    }
    //این روش مسئول افزودن TodoItem ارسالی به TodoList و هدایت مجدد به URL لیست خواهد بود.
    @PostMapping("/form")
    public RedirectView create(@ModelAttribute TodoItem todo, @ModelAttribute("todos")TodoList todos, RedirectAttributes attributes){
        todo.setCreateDate(LocalDateTime.now());
        todos.add(todo);
        attributes.addFlashAttribute("todos",todos);
        return new RedirectView("/sessionattributes/todos.html");

    }
//    این روش به سادگی TodoList را برای نمایش به Model اضافه می کند و نمای لیست را ارائه می دهد.
    @GetMapping("/todos.html")
    public String list(Model model,@ModelAttribute("todos")TodoList todos){
        model.addAttribute("todos",todos);
        return "sessionattributestodos";
    }
    @ModelAttribute("todos")
    public TodoList todos(){
        return new TodoList();
    }

}
