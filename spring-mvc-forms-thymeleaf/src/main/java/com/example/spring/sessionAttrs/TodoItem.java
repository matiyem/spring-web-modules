package com.example.spring.sessionAttrs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Create by Atiye Mousavi
 * Date: 12/11/2021
 * Time: 11:53 AM
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoItem {
    private String description;
    private LocalDateTime createDate;

    @Override
    public String toString() {
        return "TodoItem [description=" + description + ", createDate=" + createDate + "]";
    }

}
