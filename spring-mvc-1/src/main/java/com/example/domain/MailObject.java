package com.example.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Create by Atiye Mousavi
 * Date: 11/28/2021
 * Time: 9:27 AM
 **/
@Data
public class MailObject {

    @Email
    @NotNull
    @Size(min = 1,message = "Please, set an email address to send the message to it")
    private String to;
    private String recipientName;
    private String subject;
    private String text;
    private String senderName;
    private String templateEngine;
}
