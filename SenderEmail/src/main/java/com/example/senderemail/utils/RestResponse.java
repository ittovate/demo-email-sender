package com.example.senderemail.utils;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class RestResponse<T> extends ResponseEntity<T> {
    private T body;
    private String message;

    private HttpStatusCode statusCode;

    /**
     * @param statusCode
     */
    public RestResponse(HttpStatusCode statusCode) {
        super(statusCode);
        this.statusCode = statusCode;
    }

    /**
     * @param body
     * @param statusCode
     */
    public RestResponse(T body, HttpStatusCode statusCode) {
        super(body, statusCode);
        this.body = body;
        this.statusCode = statusCode;


    }

    /**
     * @param body
     * @param headers
     * @param rawStatus
     */
    public RestResponse(T body, MultiValueMap headers, int rawStatus) {
        super(body, headers, rawStatus);
    }

    /**
     * @param body
     * @param headers
     * @param statusCode
     */
    public RestResponse(T body, MultiValueMap headers, HttpStatusCode statusCode) {
        super(body, headers, statusCode);
    }

    /**
     * @param body
     * @param message
     * @param statusCode
     */
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
