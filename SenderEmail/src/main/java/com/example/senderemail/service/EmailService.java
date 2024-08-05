package com.example.senderemail.service;

import com.example.senderemail.exception.EmailValidationException;
import com.example.senderemail.model.Email;
import com.example.senderemail.utils.EmailValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@ConfigurationProperties(prefix = "spring.mail")
public class EmailService {

    private final EmailValidations emailValidator;
    private String username;
    private final JavaMailSender mailSender;

    /**
     * @param mailSender     email sender class responsible for sending the email
     * @param emailValidator utility class to validate email strings
     */
    @Autowired
    public EmailService(JavaMailSender mailSender, EmailValidations emailValidator) {
        this.mailSender = mailSender;
        this.emailValidator = emailValidator;

    }

    /**
     * @param email represents email entity to be sent
     * @return Future<ResponseEntity < ErrorResponse>>
     */
    @Async
    public CompletableFuture<Void> sendEmail(Email email) {

        try {
            emailValidator.isEmailDataValid(email);


            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(username);
            message.setTo(email.getTo());
            message.setSubject(email.getSubject());
            message.setText(email.getBody());
            mailSender.send(message);
        } catch (EmailValidationException ex) {
            throw ex;
        }
        catch (Throwable ex) {
            throw ex;
        }

        return CompletableFuture.completedFuture(null);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
