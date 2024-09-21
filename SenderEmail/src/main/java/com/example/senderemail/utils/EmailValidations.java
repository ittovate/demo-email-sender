package com.example.senderemail.utils;

import com.example.senderemail.exception.EmailValidationException;
import com.example.senderemail.model.Email;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class EmailValidations {

    /**
     * Validates an array of emails to be sent.
     *
     * @param emails
     * @return whether all the emails are valid or not.
     */
    public boolean areValidEmails(String[] emails) {
        if (emails == null) {
            return false;
        }

        for (String email : emails) {
            if (!isValidEmail(email)) {
                return false;
            }
        }
        return true;
    }


    /**
     * Validates one email string using regex expression.
     *
     * @param email
     * @return whether an email is valid or not.
     */
    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        String emailRegex = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email.toLowerCase()).matches();
    }


    /**
     * Validates the given email entity's data.
     *
     * Checks if the body and subject of the email are not null or empty and if
     * the recipient email addresses are valid. If any validation fails, an
     * EmailValidationException is thrown.
     *
     * @param email email entity to be validated
     * @throws EmailValidationException if any validation fails
     */
    public void isEmailDataValid(Email email) {
        if (email.getBody() == null || email.getBody().trim().isEmpty()) {
            throw new EmailValidationException("Error: The body of the email is empty.");
        }
        if (email.getSubject() == null || email.getSubject().trim().isEmpty()) {
            throw new EmailValidationException("Error: The subject of the email is empty." );
        }
        if (!this.areValidEmails(email.getTo())) {
            throw new EmailValidationException("Error: One or more recipient email addresses are invalid.");
        }
        }

}
