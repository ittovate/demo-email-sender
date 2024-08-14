package com.example.SenderEmail.controller;

import com.example.senderemail.controller.EmailSenderController;
import com.example.senderemail.model.Email;
import com.example.senderemail.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = EmailSenderController.class)
@ExtendWith(MockitoExtension.class)
public class TestEmailSenderController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmailService emailService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSendEmail() throws Exception {
        String[] emails = {"test@example.com"};
        Email email = new Email("body", "Subject", emails);

        doNothing().when(emailService).validateEmailAndSend(email);

        mockMvc.perform(post("/email/send-email")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(email)))
                .andExpect(status().isAccepted());
    }
}
