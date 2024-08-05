package com.example.senderemail.service;

import com.example.senderemail.exception.ErrorResponse;
import com.example.senderemail.model.Email;
import com.example.senderemail.utils.EmailValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

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
    public Future<ResponseEntity<ErrorResponse>> sendEmail(Email email) {

        isEmailDataValued(email);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        mailSender.send(message);


        ErrorResponse successResponse = new ErrorResponse(HttpStatus.ACCEPTED.value(), "The system sent a message.");
        return CompletableFuture.completedFuture(new ResponseEntity<>(successResponse, HttpStatus.ACCEPTED));

    }


    /**
     * @param email email entity to be validated
     */
    public void isEmailDataValued(Email email) {
        if (email.getBody() == null || email.getBody().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Error : The body of email is empty");
        }
        if (email.getSubject() == null || email.getSubject().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Error : The subject of email is empty");
        }

        if (!emailValidator.areValidEmails(email.getTo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    " Error :One or more recipient email addresses are invalid.");
        }

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
