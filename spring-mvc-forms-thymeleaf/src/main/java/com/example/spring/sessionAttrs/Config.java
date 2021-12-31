package com.example.spring.sessionAttrs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.Ordered;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * Create by Atiye Mousavi
 * Date: 12/11/2021
 * Time: 11:38 AM
 **/
@EnableWebMvc
@Configuration
public class Config implements WebMvcConfigurer {

//    هنگام توسعه برنامه های کاربردی وب، اغلب نیاز داریم که در چندین نما به همان ویژگی ها اشاره کنیم. برای مثال، ممکن است محتویات سبد خرید داشته باشیم که باید در چندین صفحه نمایش داده شود.
//
//یک مکان خوب برای ذخیره این ویژگی ها در جلسه کاربر است.
//
//در این آموزش، ما بر روی یک مثال ساده تمرکز می کنیم و 2 استراتژی مختلف برای کار با ویژگی session را بررسی می کنیم:
//    Using a scoped proxy
//Using the @SessionAttributes annotation


//    یکی از ویژگی های کلیدی استفاده از استراتژی پروکسی محدوده این است که تاثیری بر امضای روش نقشه برداری درخواست ندارد. این خوانایی را در مقایسه با استراتژی @SessionAttributes در سطح بسیار بالایی نگه می دارد.
//
//یادآوری این نکته می تواند مفید باشد که کنترلرها به طور پیش فرض دارای دامنه تکی هستند.
//
//به همین دلیل است که ما باید به جای تزریق ساده یک Sesscope Bean غیر پراکسی از پروکسی استفاده کنیم. ما نمی توانیم یک لوبیا با وسعت کمتر به لوبیا با وسعت بیشتر تزریق کنیم.
//
//تلاش برای انجام این کار، در این مورد، یک استثنا را با پیامی حاوی: Scope 'session' برای رشته فعلی فعال نیست، ایجاد می کند.
//
//اگر بخواهیم کنترلر خود را با محدوده جلسه تعریف کنیم، می‌توانیم از تعیین یک حالت پروکسی اجتناب کنیم. این می تواند معایبی داشته باشد، به خصوص اگر ایجاد کنترلر گران باشد زیرا باید برای هر جلسه کاربر یک نمونه کنترلر ایجاد شود.
//
//توجه داشته باشید که TodoList برای سایر اجزا برای تزریق در دسترس است. این ممکن است بسته به مورد استفاده، یک مزیت یا یک ضرر باشد. اگر در دسترس قرار دادن Bean برای کل برنامه مشکل ساز است، می توان نمونه را به جای استفاده از @SessionAttributes به کنترلر اختصاص داد، همانطور که در مثال بعدی خواهیم دید.

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Bean
    @Scope(
            value = WebApplicationContext.SCOPE_SESSION,
            proxyMode = ScopedProxyMode.TARGET_CLASS)
    public TodoList todos(){
        return new TodoList();
    }

    @Bean
    public ITemplateResolver templateResolver(){
        ClassLoaderTemplateResolver resolver=new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/sessionattrs/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }


}
