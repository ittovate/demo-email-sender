package com.example.senderemail.service;

import com.example.senderemail.exception.EmailValidationException;
import com.example.senderemail.dto.EmailDTO;
import com.example.senderemail.utils.EmailValidations;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

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
    public EmailService(JavaMailSender mailSender, EmailValidations emailValidator) {
        this.mailSender = mailSender;
        this.emailValidator = emailValidator;

    }

    /**
     * Validates the provided email data and sends the email if validation passes.
     * <p>
     * This method first validates the email data using the emailValidator and then
     * sends the email if the data is valid. If the email data is invalid, an
     * EmailValidationException is thrown.
     *
     * @param email the email entity containing the data to be validated and sent
     * @throws EmailValidationException if the email data is invalid
     */
    public void validateEmailAndSend(EmailDTO email) {
        emailValidator.isEmailDataValid(email);
        sendEmail(email);
    }

    /**
     * @param email represents email entity to be sent
     * @return Future<ResponseEntity < ErrorResponse>>
     */
    public void sendEmail(EmailDTO email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(email.to());
        message.setSubject(email.subject());
        message.setText(email.body());
        mailSender.send(message);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
