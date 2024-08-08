package com.example.senderemail.exception;

import com.example.senderemail.utils.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * handle response exception.
     *
     * @param ex
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(EmailValidationException.class)
    public ResponseEntity<RestResponse<String>> handleEmailValidationException(EmailValidationException ex) {
        RestResponse<String> response = new RestResponse<>(null, ex.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponse<String>> handleGenericException(Exception ex) {
        RestResponse<String> response = new RestResponse<>(null, "An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
