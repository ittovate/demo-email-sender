package com.example.senderemail.exception;

import com.example.senderemail.utils.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * handle response exception.
     *
     * @param ex
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(ResponseStatusException.class)
    public RestResponse<String> handleResponseStatusException(ResponseStatusException ex) {
        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = ex.getMessage();

        return new RestResponse<>(message, statusCode);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public RestResponse<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new RestResponse<>(errors, "Message: Email data are invalid", HttpStatus.BAD_REQUEST);
    }


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
