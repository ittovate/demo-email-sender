package com.example.SenderEmail.controller;


import com.example.SenderEmail.model.Email;
import com.example.SenderEmail.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
            description = "This endpoint allows you to send an email to one or more recipients. " +
                    "The email must include a subject and a body. " +
                    "The request body should contain the list of recipient email addresses in the to field, " +
                    "which must include at least one email address, and the content of the email, " +
                    "including the subject and body."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "When The Email Is Sent Successfully"),
            @ApiResponse(responseCode = "401", description = "When An Authorization Error Occurred")
    })

    @PostMapping( "/send-email")
    public void sendEmail(@RequestBody Email email){
        emailService.sendEmail(email);
    }

}
