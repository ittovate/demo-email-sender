package com.example.senderemail.model;

import jakarta.validation.constraints.NotNull;

public class Email {

    private  final String body ;

    private final String subject;

    private final String[] to;

    /**
     * @param body    represents the body of the email (String)
     * @param subject represents the subject of the email (String)
     * @param to      represents the receivers of the email (String[])
     */
    public Email(String body, String subject, String[] to) {
        this.body = body;
        this.subject = subject;
        this.to = to;
    }

    public String getBody() {
        return body;
    }


    public String getSubject() {
        return subject;
    }


    public String[] getTo() {
        return to;
    }


}
