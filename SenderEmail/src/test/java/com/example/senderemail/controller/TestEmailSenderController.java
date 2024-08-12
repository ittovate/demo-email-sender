package com.example.senderemail.controller;

import com.example.senderemail.model.Email;
import com.example.senderemail.service.EmailService;
import com.example.senderemail.utils.EmailValidations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = EmailSenderController.class)
public class TestEmailSenderController {

    @Autowired
//    private MockMvc mockMvc;

    @MockBean
    private EmailService myService;
    private final EmailValidations validations = new EmailValidations();
    private final JavaMailSender mailSender = new JavaMailSenderImpl();
    private final EmailService service = new EmailService(mailSender, validations);
    private final EmailSenderController controller = new EmailSenderController(service);

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
        assertInstanceOf(ResponseEntity.class , controller.sendEmail(email));
//        assertNotSame();
//        assertSame();
//        assertDoesNotThrow(() -> validations.isEmailDataValid(email));
    }


}
