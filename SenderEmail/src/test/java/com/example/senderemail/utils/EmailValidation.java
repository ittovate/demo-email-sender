package com.example.senderemail.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = EmailValidations.class)
public class EmailValidation {

    private final EmailValidations validations = new EmailValidations();


    @ParameterizedTest
    @ValueSource(strings = {
            "test@example.com",
            "x@example.com",
            "example@s.example",
            "john.doe\"@example.com",
            "firstname.lastname@example.com",
            "email@subdomain.example.com",
            "user@domain.com",
    })
    void validEmails(String email) {
        assertTrue(validations.isValidEmail(email));
    }

    @Test
    void validEmailsArray() {
        assertTrue(validations.areValidEmails(new String[]{
                "test@example.com",
                "1234567890@example.com",
                "x@example.com",
                "example@s.example",
                "john.doe\"@example.com",
                "firstname.lastname@example.com",
                "email@subdomain.example.com",
                "user@domain.com",
        }));
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "email\"@example.com",
            "plainaddress",
            "@missing-local-part.com",
            "username@example,com",
            "username@.example.com",
            "username@example..com",
            "username@-example.com",
            "username@example.com.",
            "username@example.com-",
            "username@example..com",
            "username@.com",
            "user@domain",
            "user@.domain.com",
            ".username@example.com",
            "user@domain..com",
            "\" \"@example.org",
            "user@[IPv6:2001:db8::1]",
            "firstname+lastname@example.com",
            "email@[123.123.123.123]",
            "user.name+tag+sorting@example.com",
            "example-indeed@strange-example.com",
            "admin@mailserver1",
    })
    void invalidEmails(String email) {
        assertFalse(validations.isValidEmail(email));
    }

    @Test
    void invalidEmailsArray() {
        assertFalse(validations.areValidEmails(new String[]{
                "email\"@example.com",
                "1234567890@example.com",
                "plainaddress",
                "@missing-local-part.com",
                "username@example,com",
                "username@.example.com",
                "username@example..com",
                "username@-example.com",
                "username@example.com.",
                "username@example.com-",
                "username@example..com",
                "username@.com",
                "user@domain",
                "user@.domain.com",
                ".username@example.com",
                "user@domain..com",
                "\" \"@example.org",
                "user@[IPv6:2001:db8::1]",
                "firstname+lastname@example.com",
                "email@[123.123.123.123]",
                "user.name+tag+sorting@example.com",
                "example-indeed@strange-example.com",
                "admin@mailserver1",
        }));
    }
}

