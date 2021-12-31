package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Create by Atiye Mousavi
 * Date: 11/27/2021
 * Time: 12:35 PM
 **/
@Controller
public class FileUploadController implements HandlerExceptionResolver {
    //HandlerExceptionResolver مي تواند توسط برنامه کاربردي براي حل استثناهاي پرتاب شده در طول پردازش يک درخواست
//    HTTP پياده سازي شود. استثنا مي تواند توسط يکي از روش هاي کنترل کننده برنامه يا خارج از آن، اما در طول پردازش يک
//    درخواست ايجاد شود. متد، HandlerExceptionResolver#resolveException()، نمونه اي از ModelAndView را برمي گرداند
//    که صفحه خطا را مشخص مي کند. پياده سازي ها معمولاً به عنوان لوبيا در زمينه برنامه ثبت مي شوند. برنامه ثبت شده
//    HandlerExceptionResolvers فقط در صورتي فراخواني مي شود که استثنا قبلاً توسط HandlerExceptionResolvers پيش
//فرض مديريت نشده باشد. با اين حال، مي‌توانيم ترتيب حل‌کننده‌ها را طوري تغيير دهيم که بتوان ابتدا يک حل‌کننده معين را فراخواني کرد.
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView=new ModelAndView("file");
        if (e instanceof MaxUploadSizeExceededException){
            modelAndView.getModel().put("message","File size exceeds limit!");
        }
        return modelAndView;
    }
    @RequestMapping(value = "/uploadFile",method = RequestMethod.GET)
    public String getImageView(){
        return "file";
    }
    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    public ModelAndView uploadFile(MultipartFile file) throws IOException {
        ModelAndView modelAndView=new ModelAndView("file");

        InputStream in= file.getInputStream();
        File currDir=new File(".");
        String path=currDir.getAbsolutePath();
        FileOutputStream f=new FileOutputStream(path.substring(0,path.length()-1)+file.getOriginalFilename());
        int ch=0;
        while ((ch=in.read()) !=-1){
            f.write(ch);
        }
        f.flush();
        f.close();

        modelAndView.getModel().put("message","File uploaded successfully!");
        return modelAndView;


    }
}
