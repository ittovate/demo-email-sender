package com.example.senderemail.exception;

import com.example.senderemail.utils.APIResponse;
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

import static com.example.senderemail.constant.ValidationConstant.GENERAL_EXCEPTION_HANDLER_MESSAGE;

@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * handle response exception.
     *
     * @param ex
     * @return ResponseEntity<ErrorResponse>
     */
    @ExceptionHandler(EmailValidationException.class)
    public APIResponse<String> handleEmailValidationException(EmailValidationException ex) {
        return new APIResponse<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public APIResponse<String> handleGenericException(Exception ex) {
        return new APIResponse<>(GENERAL_EXCEPTION_HANDLER_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
