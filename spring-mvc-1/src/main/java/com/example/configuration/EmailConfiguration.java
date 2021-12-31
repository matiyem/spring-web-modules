package com.example.configuration;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Properties;

@ComponentScan(basePackages = {"com.example.mail"})
@PropertySource(value={"classpath:application.properties"})
public class EmailConfiguration {

    @Value("${spring.mail.host}")
    private String mailServerHost;

    @Value("${spring.mail.port}")
    private Integer mailServerPort;

    @Value("${spring.mail.username}")
    private String mailServerUsername;
//
    @Value("${spring.mail.password}")
    private String mailServerPassword;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String mailServerAuth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String mailServerStartTls;

    @Value("${spring.mail.templates.path}")
    private String mailTemplatesPath;

    @Bean
    public JavaMailSender getJavaMailSender(){
        // در اصلjavaMailSender یک ساب اینترفیس است که از پیغام های mime پشتیبانی میکند و میتوتن ساخت برای استفاده از مکانیزمMimeMessagePreparator پیشنهاد میشود از این اینترفیس استفاده شود

        //این در اصل پیاده سازی javaMailSender است همچنین از mimeMessage و همچنین simpleMailMessage پشتیبانی میشود
        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        //تنظیمات سرور است
        mailSender.setHost(mailServerHost);
        mailSender.setPort(mailServerPort);
//
        mailSender.setUsername(mailServerUsername);
        mailSender.setPassword(mailServerPassword);

        Properties props=mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol","smtp");
        props.put("mail.smtp.auth",mailServerAuth);
        props.put("mail.smtp.starttls.enable",mailServerStartTls);
        props.put("mail.debug","true");

        return mailSender;
    }
    @Bean
    public SimpleMailMessage templateSimpleMessage(){
        //برای هندل کردن text formatting ارسال ایمیل است
        SimpleMailMessage message=new SimpleMailMessage();
        message.setText("This is the test email template for your email:\n%s\n");
        return message;
    }
    @Bean
    public SpringTemplateEngine thymeleadTemplateEngine(ITemplateResolver templateResolver){
        //مرحله آخر کانفیگ کردن ایجاد این متد است که مشخص کنیم engine باید از کدام resolver استفاده کند
        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setTemplateEngineMessageSource(emailMessageSource());
        return templateEngine;
    }
    @Bean
    public ITemplateResolver thymeleafClassLoaderTemplateResolver(){
        ClassLoaderTemplateResolver templateResolver=new ClassLoaderTemplateResolver();
        //برای مشخص کردن آدرس اکسترنال template است
        templateResolver.setPrefix(mailTemplatesPath + "/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;

    }
    //برای آدرس دهی فایل ها از طریق jar
//    برای مکان یابی قالب ها از JAR، از ClassLoaderTemplateResolver استفاده می کنیم. الگوهای ما در دایرکتوری main/resources/mail-templates قرار دارند، بنابراین ویژگی Prefix را نسبت به فهرست منابع تنظیم می کنیم:
//    @Bean
//    public ITemplateResolver thymeleafFilesystemTemplateResolver() {
//        FileTemplateResolver templateResolver = new FileTemplateResolver();
//        templateResolver.setPrefix(mailTemplatesPath + "/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML");
//        templateResolver.setCharacterEncoding("UTF-8");
//        return templateResolver;
//    }
    @Bean
    public FreeMarkerConfigurer freeMarkerClassLoaderConfig(){
        //برای مشخص کردن جایگاه فایل های template است
        Configuration configuration=new Configuration(Configuration.VERSION_2_3_27);
        TemplateLoader templateLoader=new ClassTemplateLoader(this.getClass(),"/" + mailTemplatesPath);
        configuration.setTemplateLoader(templateLoader);
        FreeMarkerConfigurer freeMarkerConfigurer=new FreeMarkerConfigurer();
        freeMarkerConfigurer.setConfiguration(configuration);
        return freeMarkerConfigurer;
    }
    //    @Bean
//    public FreeMarkerConfigurer freemarkerFilesystemConfig() throws IOException {
//        Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);
//        TemplateLoader templateLoader = new FileTemplateLoader(new File(mailTemplatesPath));
//        configuration.setTemplateLoader(templateLoader);
//        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
//        freeMarkerConfigurer.setConfiguration(configuration);
//        return freeMarkerConfigurer;
//    }
    @Bean
    public ResourceBundleMessageSource emailMessageSource(){
        //In order to manage translations with Thymeleaf, we can specify a MessageSource instance to
        // the engine:
        final ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
        messageSource.setBasenames("mailMessage");
        return messageSource;
    }
}
