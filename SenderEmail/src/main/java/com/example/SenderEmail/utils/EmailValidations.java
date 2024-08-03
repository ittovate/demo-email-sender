package com.example.SenderEmail.utils;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class EmailValidations {

    public boolean areValidEmails(String[] emails) {
        if (emails == null) {
            return false;
        }

        for (String email : emails) {
            if (!isValidEmail(email))
                return false;
        }
        return true;
    }

    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        String emailRegex = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";
//        String emailRegex = "^(?!([A-Z]{3,}[0-9]{3,}@[a-z]{2,}-[a-z]{2,}.[a-z]{2,}$)).*$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email.toLowerCase()).matches()) {
            return false;
        }
        return true;
    }


}
