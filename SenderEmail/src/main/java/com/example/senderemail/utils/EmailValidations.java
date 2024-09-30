package com.example.senderemail.utils;

import com.example.senderemail.dto.EmailDTO;
import com.example.senderemail.exception.EmailValidationException;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

import static com.example.senderemail.constant.ValidationConstant.*;

@Component
public class EmailValidations {

    /**
     * Validates an array of emails to be sent.
     *
     * @param emails
     * @return whether all the emails are valid or not.
     */
    public boolean areValidEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
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
     * <p>
     * Checks if the body and subject of the email are not null or empty and if
     * the recipient email addresses are valid. If any validation fails, an
     * EmailValidationException is thrown.
     *
     * @param email email entity to be validated
     * @throws EmailValidationException if any validation fails
     */
    public void isEmailDataValid(EmailDTO email) {
        if (email.body() == null || email.body().trim().isEmpty()) {
            throw new EmailValidationException(EMAIL_VALIDATION_EMPTY_EMAIL_MESSAGE);
        }
        if (email.subject() == null || email.subject().trim().isEmpty()) {
            throw new EmailValidationException(EMAIL_VALIDATION_EMPTY_SUBJECT_MESSAGE);
        }
        if (!this.areValidEmails(email.to())) {
            throw new EmailValidationException(EMAIL_VALIDATION_INVALID_MESSAGE);
        }
    }

}
