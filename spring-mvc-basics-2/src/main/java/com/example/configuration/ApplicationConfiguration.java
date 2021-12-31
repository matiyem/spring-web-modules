package com.example.configuration;

import com.example.controller.rss.ArticleRssFeedViewResolver;
import com.example.controller.rss.JsonChannelHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.example.springmvcforms", "com.example.controller", "com.example.validator", "com.example.mail", "com.example.service" })
public class ApplicationConfiguration implements WebMvcConfigurer {
    //JavaMail SendFailedException را برای رسیدگی به موقعیت هایی که پیامی ارسال نمی شود ارائه می دهد. اما ممکن است هنگام ارسال ایمیل به آدرس نادرست، این استثنا را دریافت نکنیم. دلیل به شرح ذیل است:
    //
    //مشخصات پروتکل SMTP در RFC 821 کد بازگشتی 550 را مشخص می کند که سرور SMTP باید هنگام تلاش برای ارسال ایمیل به آدرس نادرست بازگرداند. اما اکثر سرورهای عمومی SMTP این کار را انجام نمی دهند. در عوض، آنها یک ایمیل "تحویل ناموفق" ارسال می کنند یا اصلاً بازخوردی نمی دهند.
    //
    //به عنوان مثال، سرور SMTP Gmail پیام "تحویل ناموفق" را ارسال می کند. و ما هیچ استثنایی در برنامه خود نداریم.

    //

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ContentNegotiatingViewResolver viewResolver(ContentNegotiationManager cnManager) {
        ContentNegotiatingViewResolver cnvResolver = new ContentNegotiatingViewResolver();
        cnvResolver.setContentNegotiationManager(cnManager);
        List<ViewResolver> resolvers = new ArrayList<>();

        InternalResourceViewResolver bean = new InternalResourceViewResolver("/WEB-INF/views/",".jsp");
        ArticleRssFeedViewResolver articleRssFeedViewResolver = new ArticleRssFeedViewResolver();

        resolvers.add(bean);
        resolvers.add(articleRssFeedViewResolver);

        cnvResolver.setViewResolvers(resolvers);
        return cnvResolver;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(5242880);
        return multipartResolver;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter());
        converters.add(new RssChannelHttpMessageConverter());
        converters.add(new JsonChannelHttpMessageConverter());
    }

}
