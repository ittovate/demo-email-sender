package com.example.senderemail.controller;


import com.example.senderemail.model.Email;
import com.example.senderemail.service.EmailService;
import com.example.senderemail.utils.RestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


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
            @ApiResponse(responseCode = "201", description = "When The Email Is Sent Successfully"),
            @ApiResponse(responseCode = "400", description = "When An Authorization Error Occurred")
    })


    @PostMapping("/send-email")
    public ResponseEntity<RestResponse<Email> > sendEmail( @RequestBody Email email) {

        emailService.validateEmailAndSend(email);
       RestResponse<Email> response = new RestResponse<>(email, "Email has been sent successfully ", HttpStatus.ACCEPTED);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }



}
