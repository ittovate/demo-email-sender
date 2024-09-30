package com.example.senderemail.utils;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class APIResponse<T> extends ResponseEntity<APIResponse.Response<T>> {

    /**
     * @param body
     * @param statusCode
     */
    public APIResponse(T body, HttpStatusCode statusCode) {
        super(new Response<>(body, statusCode.value()), statusCode);
    }

    /**
     * @param body
     * @param message
     * @param statusCode
     */
    public APIResponse(T body, String message, HttpStatusCode statusCode) {
        super(new Response<>(body, message, statusCode.value()), statusCode);
    }

    /**
     * @param message
     * @param statusCode
     */
    public APIResponse(String message, HttpStatusCode statusCode) {
        super(new Response<>(null, message, statusCode.value()), statusCode);
    }


    public static class Response<T> {
        private T data;
        private String message;

        private int statusCode;

        public Response(T data, int statusCode) {
            this.data = data;
            this.message = null;
            this.statusCode = statusCode;
        }

        public Response(T data, String message, int statusCode) {
            this.data = data;
            this.message = message;
            this.statusCode = statusCode;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

    }
}
