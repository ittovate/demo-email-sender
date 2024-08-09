package com.example.senderemail.model;


import com.example.senderemail.annotations.ValidStringArray;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;

import java.util.List;

public class Email {



    private final String body;


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
