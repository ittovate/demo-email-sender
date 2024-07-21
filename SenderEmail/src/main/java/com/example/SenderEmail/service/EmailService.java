package com.example.SenderEmail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmailService {

    private final JavaMailSender mailSender ;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendEmail(List<String> to , String subject , String body ){

        SimpleMailMessage message =new SimpleMailMessage( ) ;

        message.setFrom("mostafadfrg@gmail.com");
         message.setTo(to.toArray());

       // message.setTo(new String[] {"recipient1@example.com", "recipient2@example.com", "recipient3@example.com"});
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message );
    }

}
