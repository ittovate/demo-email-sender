package com.example.senderemail.controller;


import com.example.senderemail.dto.EmailDTO;
import com.example.senderemail.service.EmailService;
import com.example.senderemail.utils.APIResponse;
import com.example.senderemail.utils.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.senderemail.constant.SwaggerConstant.*;


@RestController
@RequestMapping("/api/v1/email")
@Tag(name = CONTROLLER_NAME, description = CONTROLLER_DESCRIPTION)
public class EmailSenderController {
    private final EmailService emailService;

    /**
     * @param emailService injection of the email service
     */
    public EmailSenderController(EmailService emailService) {
        this.emailService = emailService;
    }


    /**
     * @param email represents the email entity
     * @return APIResponse<email>
     */
    @Operation(
            method = METHOD_POST,
            summary = SEND_EMAIL_SUMMARY,
            description = SEND_EMAIL_DESCRIPTION
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = SEND_EMAIL_STATUS_OK, description = SEND_EMAIL_STATUS_OK_DESCRIPTION),
            @ApiResponse(responseCode = SEND_EMAIL_STATUS_BAD_REQUEST, description = SEND_EMAIL_STATUS_BAD_REQUEST_DESCRIPTION)
    })
    @PostMapping("/send-email")
    public APIResponse<EmailDTO> sendEmail(@RequestBody EmailDTO email) {
        emailService.validateEmailAndSend(email);
        return ResponseUtil.createUnifiedResponse(email, SEND_EMAIL_RESPONSE_MESSAGE, HttpStatus.ACCEPTED);
    }


}
