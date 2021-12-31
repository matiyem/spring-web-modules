package com.example.spring.sessionAttrs;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

/**
 * Create by Atiye Mousavi
 * Date: 12/11/2021
 * Time: 12:18 PM
 **/
@Controller
@RequestMapping("/scopedproxy")
@AllArgsConstructor
public class TodoControllerWithScopedProxy {
//    در این تنظیمات، TodoList ما به عنوان یک @Bean با محدوده جلسه پیکربندی شده است که توسط یک پروکسی پشتیبانی می شود. این واقعیت که @Bean یک پروکسی است به این معنی است که ما می‌توانیم آن را به @Controller با دامنه singleton خود تزریق کنیم.
//
//از آنجایی که هیچ جلسه ای برای شروع اولیه متن وجود ندارد، Spring یک پروکسی از TodoList ایجاد می کند تا به عنوان یک وابستگی تزریق شود. نمونه هدف TodoList در صورت نیاز ، نمونه سازی می شود.



//


    private TodoList todos;

    @GetMapping("/form")
    public String showForm(Model model) {
        if (!todos.isEmpty()) {
            model.addAttribute("todo", todos.peekLast());
        } else {
            model.addAttribute("todo", new TodoItem());
        }
        return "scopedproxyform";
    }
    @PostMapping("/form")
    public String creat(@ModelAttribute TodoItem todo){
        todo.setCreateDate(LocalDateTime.now());
        todos.add(todo);
        return "redirect:/scopedproxy/todos.html";
    }
    @GetMapping("/todos.html")
    public String list(Model model){
        model.addAttribute("todos",todos);
        return "scopedproxytodos";
    }

}
