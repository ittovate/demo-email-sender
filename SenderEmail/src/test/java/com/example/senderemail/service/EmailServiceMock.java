package com.example.SenderEmail.service;

import com.example.senderemail.model.Email;
import com.example.senderemail.service.EmailService;
import com.example.senderemail.utils.EmailValidations;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class EmailServiceMock {

    @Mock
    private EmailValidations emailValidator;

    @InjectMocks
    private EmailService emailService;

    @Test
    public void testSendEmail_ToSaveEmailInEntity() {
        String[] toEmails = {"email@gmail.com"};
        Email email = new Email("This is the body", "This is the subject", toEmails);

        doNothing().when(emailValidator).isEmailDataValid(email);

        emailService.validateEmailAndSend(email);

        Assertions.assertThat(email.getBody()).isNotNull();
        Assertions.assertThat(email.getBody()).isNotEmpty();
        Assertions.assertThat(email.getBody()).isNotEmpty();

        Assertions.assertThat(email.getSubject()).isNotNull();
        Assertions.assertThat(email.getSubject()).isNotEmpty();
        Assertions.assertThat(email.getSubject()).isNotEmpty();


        Assertions.assertThat(email.getTo()).isNotNull();
        Assertions.assertThat(email.getTo()).isNotEmpty();
        Assertions.assertThat(email.getTo()).isNotEmpty();



    }

    @Test
    public void EmailService_FailsIf_BodyIsBlank() {
        String[] toEmails = {"email@gmail.com"};
        Email email = new Email( "      " , "This is the subject", toEmails);

        doNothing().when(emailValidator).isEmailDataValid(email);

        emailService.validateEmailAndSend(email);

        Assertions.assertThat(email.getBody()).isBlank();

    }



    @Test
    public void EmailService_FailsIf_SubjectIsBlank() {
        String[] toEmails = {"email@gmail.com"};
        Email email = new Email( "this is a body"  , "     ", toEmails);

        doNothing().when(emailValidator).isEmailDataValid(email);

        emailService.validateEmailAndSend(email);
        Assertions.assertThat(email.getSubject()).isBlank();

    }
}
