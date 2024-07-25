package com.example.SenderEmail.exception;

public class ErrorResponse {
    private final int STATUS_CODE;
    private final String  MESSAGE;


    public ErrorResponse(int STATUS_CODE, String MESSAGE) {
        this.STATUS_CODE = STATUS_CODE;
        this.MESSAGE = MESSAGE;

    }

    public int getSTATUS_CODE() {
        return STATUS_CODE;
    }

    public String getMessage() {
        return MESSAGE;
    }


}
