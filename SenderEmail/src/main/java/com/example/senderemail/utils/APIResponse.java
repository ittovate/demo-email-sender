package com.example.senderemail.utils;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class APIResponse<T> extends ResponseEntity<APIResponse.Response<T>> {
    public APIResponse(T body, String message, HttpStatusCode statusCode) {
        super(new Response<>(body, message, statusCode.value()), statusCode);
    }

    public record Response<T>(T data, String message, int statusCode) {
    }

}
