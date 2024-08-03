package com.example.SenderEmail.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class RestResponse<T> extends  ResponseEntity<T>{
    private T body;
    private String message;

    private HttpStatusCode statusCode;

    public RestResponse(HttpStatusCode statusCode) {
        super(statusCode);
        this.statusCode = statusCode;
    }

    public RestResponse(T body, HttpStatusCode statusCode) {
        super(body, statusCode);
        this.body = body;
        this.statusCode = statusCode;


    }


    public RestResponse(T body, MultiValueMap headers, int rawStatus) {
        super(body, headers, rawStatus);
    }

    public RestResponse(T body, MultiValueMap headers, HttpStatusCode statusCode) {
        super(body, headers, statusCode);
    }

    public RestResponse(T body, String message, HttpStatusCode statusCode) {
        super(body, statusCode);
        this.message = message;
        this.body = body;
        this.statusCode = statusCode;
    }


    @Override
    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        this.statusCode = statusCode;
    }


}


//public record RestResponse<T>(T body,
//                              String message,
//                              HttpStatusCode statusCode) {}
