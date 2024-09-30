package com.example.senderemail.constant;

public class ValidationConstant {

    public static final String EMAIL_VALIDATION_REGEX = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$";
    public static final String EMAIL_VALIDATION_EMPTY_EMAIL_MESSAGE = "Error: The body of the email is empty.";
    public static final String EMAIL_VALIDATION_EMPTY_SUBJECT_MESSAGE = "Error: The subject of the email is empty.";
    public static final String EMAIL_VALIDATION_INVALID_MESSAGE = "Error: One or more recipient email addresses are invalid.";
    public static final String GENERAL_EXCEPTION_HANDLER_MESSAGE = "Error: One or more recipient email addresses are invalid.";


}
