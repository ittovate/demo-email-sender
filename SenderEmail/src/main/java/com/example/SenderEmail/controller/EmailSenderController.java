package com.example.SenderEmail.controller;


import com.example.SenderEmail.model.Email;
import com.example.SenderEmail.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/email")
public class EmailSenderController {

    @Autowired
    EmailService emailService;


    @Operation(
            method = "POST",
            summary = "Send Email",
            description = "Giver The Email Body, Send an Email",
            responses = {
                    @ApiResponse(responseCode = "200", description = "When The Email Is Sent Successfully"),
                    @ApiResponse(responseCode = "401", description = "When An Authorization Error Occurred")
            }
    )
    @PostMapping( "/send-email")
    public void sendEmail(@RequestBody Email email){
        emailService.sendEmail(email);
    }

}
