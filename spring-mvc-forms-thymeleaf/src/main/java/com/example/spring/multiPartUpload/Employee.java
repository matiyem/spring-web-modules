package com.example.spring.multiPartUpload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * created by Atiye Mousavi
 * Date: 12/10/2021
 * Time: 6:09 PM
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private String name;
    private MultipartFile document;
}
