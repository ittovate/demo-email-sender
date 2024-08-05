package com.example.senderemail.utils;

import com.example.senderemail.model.Email;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = EmailValidations.class)
class TestEmailValidation {

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


    private static Stream<Arguments> emailProvider() {
        return Stream.of(
                Arguments.of(new Email("test body", "test subject", new String[]{"test@example.com"})),
                Arguments.of(new Email("test body", "test subject", new String[]{"test@example.com",})),
                Arguments.of(new Email("test body", "test subject", new String[]{"x@example.com",})),
                Arguments.of(new Email("test body", "test subject", new String[]{"example@s.example",})),
                Arguments.of(new Email("test body", "test subject", new String[]{"john.doe\"@example.com",})),
                Arguments.of(new Email("test body", "test subject", new String[]{"firstname.lastname@example.com",})),
                Arguments.of(new Email("test body", "test subject", new String[]{"email@subdomain.example.com",})),
                Arguments.of(new Email("test body", "test subject", new String[]{"user@domain.com",}))
        );
    }
    @ParameterizedTest
    @MethodSource("emailProvider")
    void validEmailObjects(Email email) {
        assertDoesNotThrow(() -> validations.isEmailDataValid(email));
    }


}
