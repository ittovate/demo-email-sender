package com.example.senderemail.controller;


import com.example.senderemail.exception.EmailValidationException;
import com.example.senderemail.model.Email;
import com.example.senderemail.service.EmailService;
import com.example.senderemail.utils.RestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
@RequestMapping("/email")
public class EmailSenderController {


    private final EmailService emailService;


    /**
     * @param emailService injection of the email service
     */
    public EmailSenderController(@Autowired EmailService emailService) {
        this.emailService = emailService;
    }


    /**
     * @param email represents the email entity
     * @return RestResponse<email>
     */
    @Operation(
            method = "POST",
            summary = "Send Email",
            description = "This endpoint allows you to send an email to one or more recipients. "
                    + "The email must include a subject and a body. "
                    + "The request body should contain the list of recipient email addresses in the to field, "
                    + "which must include at least one email address, and the content of the email, "
                    + "including the subject and body."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "When The Email Is Sent Successfully"),
            @ApiResponse(responseCode = "401", description = "When An Authorization Error Occurred")
    })

    @Async
    @PostMapping("/send-email")
    public CompletableFuture<RestResponse<Email>> sendEmail(@RequestBody Email email) {

        try {
            emailService.sendEmail(email).get();
        } catch (EmailValidationException ex) {
            throw ex;
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.completedFuture(new RestResponse<>(email, HttpStatus.ACCEPTED));
    }

}
