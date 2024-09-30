package com.example.senderemail.utils;

import org.springframework.http.HttpStatusCode;

public final class ResponseUtil {

    /**
     * Create unified response api response.
     *
     * @param <T>        the type parameter
     * @param statusCode the status code
     * @param message    the message
     * @param body       the body
     * @return the api response
     */
    public static <T> APIResponse<T> createUnifiedResponse(T body, String message, HttpStatusCode statusCode) {
        return new APIResponse<>(body, message, statusCode);
    }

    private ResponseUtil() {
    }
}
