package com.example.senderemail.validation;

import com.example.senderemail.annotations.ValidStringArray;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class EmailArrayValidator implements ConstraintValidator<ValidStringArray, String[]> {
    private Pattern pattern;

    @Override
    public void initialize(ValidStringArray constraintAnnotation) {
        this.pattern = Pattern.compile(constraintAnnotation.regex());
    }

    public boolean isValid(String[] emails, ConstraintValidatorContext context) {
        if (emails == null || emails.length == 0) {
            return false;
        }

        for (String email : emails) {
            if (email == null || !this.pattern.matcher(email.toLowerCase()).matches()) {
                return false;
            }
        }
        return true;
    }
}
