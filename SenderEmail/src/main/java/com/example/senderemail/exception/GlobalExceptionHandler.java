//package com.example.senderemail.exception;
//
//import com.example.senderemail.utils.RestResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.server.ResponseStatusException;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//
//    /**
//     * handle response exception.
//     *
//     * @param ex
//     * @return ResponseEntity<ErrorResponse>
//     */
//    @ExceptionHandler(ResponseStatusException.class)
//    public RestResponse<String> handleResponseStatusException(ResponseStatusException ex) {
//        System.out.println("came here in global exception handler ");
//        HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
//        String message = ex.getMessage();
//
//        return new RestResponse<>(message, statusCode);
//    }
//
//
//}
