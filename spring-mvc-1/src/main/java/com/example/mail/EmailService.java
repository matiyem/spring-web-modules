package com.example.mail;

import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

/**
 * Create by Atiye Mousavi
 * Date: 11/27/2021
 * Time: 1:25 PM
 **/
public interface EmailService {
    void sendSimpleMessage(String to,String subject,String text);
    void sendSimpleMessageUsingTemplate(String to,String subject,String ...template);
    void sendMessageWithAttachment(String to,String subject,String text,String pathToAttachment) throws MessagingException;
    void sendMessageUsingThymeleafTemplate(String to, String subject, Map<String,Object> templateModel) throws MessagingException;
    void sendMessageUsingFreemarkerTemplate(String to,String subject,Map<String,Object> templateModel) throws IOException, TemplateException, MessagingException;
}
