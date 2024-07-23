package com.example.SenderEmail.service;

import com.example.SenderEmail.exception.ErrorResponse;
import com.example.SenderEmail.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

@Service
@ConfigurationProperties(prefix = "spring.mail")
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    private String username;
    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {

        this.mailSender = mailSender;
    }

    @Async
    public ResponseEntity<ErrorResponse> sendEmail(Email email) {

        isEmailDataValued( email ) ;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(username);
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        mailSender.send(message);

        logger.info("The system sent a message.");

        ErrorResponse successResponse = new ErrorResponse(HttpStatus.ACCEPTED.value(), "The system sent a message."  );
        return new ResponseEntity<>(successResponse, HttpStatus.ACCEPTED);

    }

    private void isEmailDataValued(Email email ){
        if (email.getBody() == null || email.getBody().trim().isEmpty() ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Error : The body of email is empty");
        }
        if (email.getSubject() == null || email.getSubject().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Error : The subject of email is empty");
        }

        if (! areValidEmails(email.getTo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Error :One or more recipient email addresses are invalid.");
        }
        logger.info("The email Data is valued .");
    }

    private boolean areValidEmails(String[] emails) {
        if (emails == null) {
            return false;
        }
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        for (String email : emails) {
            if (!pattern.matcher(email).matches()) {
                return false;
            }
        }
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
