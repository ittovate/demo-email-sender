package com.example.SenderEmail;

import com.example.SenderEmail.model.Email;
import com.example.SenderEmail.service.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class SenderEmailApplication {
    private EmailService emailService;

    public SenderEmailApplication(EmailService emailService) {
        this.emailService = emailService;
    }

    public static void main(String[] args) {
        // SpringApplication.run(SenderEmailApplication.class, args);

        ApplicationContext context = SpringApplication.run(SenderEmailApplication.class, args);
        SenderEmailApplication app = context.getBean(SenderEmailApplication.class);
//        app.Run();
    }

//    private void Run() {
//
//        String[] toArray = new String[]{"mostafahass314@gmail.com", "mustafa.2buelmagd@gmail.com"};
//        Email email = new Email();
//        email.setBody("This is a body welcome to ");
//        email.setTo(toArray);
//        email.
//        emailService.sendEmail(toArray, "The first Email ", "This is a body welcome to ");
//    }

}
