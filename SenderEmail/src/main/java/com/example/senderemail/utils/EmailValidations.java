package com.example.senderemail.utils;

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


}
