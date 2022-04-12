package com.example.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/*
    Create by Atiye Mousavi 
    Date: 4/10/2022
    Time: 3:00 PM
**/
@Controller
public class MultipartController {

    @Autowired
    ServletContext context;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public ModelAndView FileuploadController(@RequestParam("file") MultipartFile file) {
        ModelAndView modelAndView = new ModelAndView("index");

        try {
            InputStream in = file.getInputStream();
            String path = new File(".").getAbsolutePath();
            FileOutputStream f = new FileOutputStream(path.substring(0, path.length() - 1) + "/uploads/" + file.getOriginalFilename());

            try {
                int ch;
                while ((ch = in.read()) != -1) {
                    f.write(ch);
                }
                modelAndView.getModel().put("message", "File uploaded successfully!");
            } catch (Exception e) {
                System.out.println("Exception uploading multipart: " + e);
            } finally {
                f.flush();
                f.close();
                in.close();
            }
        } catch (IOException e) {
            System.out.println("Exception uploading multipart: " + e);
        }
        return modelAndView;
    }
}
