package com.example.senderemail.exception;

public record ErrorResponse(int statusCode, String message) {
}
