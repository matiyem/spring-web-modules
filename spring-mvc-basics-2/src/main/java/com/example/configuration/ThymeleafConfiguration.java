package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
/**
 * created by Atiye Mousavi
 * Date: 11/26/2021
 * Time: 5:41 PM
 **/

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.example.springmvcforms", "com.example.controller", "com.example.validator" })
public class ThymeleafConfiguration {
    //Thymeleaf یک موتور قالب جاوا است که می تواند فایل های HTML، XML، متن، جاوا اسکریپت یا CSS را پردازش کند. برخلاف سایر موتورهای قالب، Thymeleaf اجازه استفاده از قالب ها را به عنوان نمونه اولیه می دهد، به این معنی که می توان آنها را به عنوان فایل های ثابت
    // مشاهده کرد.

    //این کلاس برای کانفیگ کردن استفاده از این template است
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());
        return templateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver(){
        //در اینجا داریم جایی که tempalte ما قرار دارد را مشخص میکنیم
        SpringResourceTemplateResolver templateResolver=new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(){
        ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        return viewResolver;
    }
}
