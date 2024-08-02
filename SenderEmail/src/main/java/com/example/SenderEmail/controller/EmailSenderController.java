package com.example.SenderEmail.controller;


import com.example.SenderEmail.model.Email;
import com.example.SenderEmail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/email")
public class EmailSenderController {

    @Autowired
    EmailService emailService;


    @PostMapping( "/send-email")
    public void sendEmail(@RequestBody Email email){
        emailService.sendEmail(email);
    }

}
