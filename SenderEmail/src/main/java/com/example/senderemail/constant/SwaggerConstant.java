package com.example.senderemail.constant;

public class SwaggerConstant {
    public static final String TITLE = "Demo Email Sender";
    public static final String VERSION = "0.0.1";
    public static final String DESCRIPTION = "Demo of using spring email sender";
    public static final String CONTACT_NAME = "Mostafa Hussein";
    public static final String CONTACT_EMAIL = "mostafadfrg@gmail.com";
    public static final String CONTACT_URL = "https://github.com/orgs/ittovate/";
    public static final String DEVELOPMENT_SERVER_URL = "http://localhost:8080";
    public static final String DEVELOPMENT_SERVER_DESCRIPTION = "Development Server";

    //================================================= Email Sender Controller =================================================//

    public static final String CONTROLLER_NAME= "Email Sender Controller";
    public static final String CONTROLLER_DESCRIPTION= "This controller is used to send emails";
    public static final String METHOD_POST = "POST";
    public static final String SEND_EMAIL_SUMMARY = "Send Email";

    public static final String SEND_EMAIL_DESCRIPTION = "This endpoint allows you to send an email to one or more recipients. "
            + "The email must include a subject and a body. "
            + "The request body should contain the list of recipient email addresses in the to field, "
            + "which must include at least one email address, and the content of the email, "
            + "including the subject and body.";

    public static final String SEND_EMAIL_STATUS_OK = "201";
    public static final String SEND_EMAIL_STATUS_OK_DESCRIPTION = "When The Email Is Sent Successfully";

    public static final String SEND_EMAIL_STATUS_BAD_REQUEST = "400";
    public static final String SEND_EMAIL_STATUS_BAD_REQUEST_DESCRIPTION = "When The Email Is Sent Successfully";
    public static final String SEND_EMAIL_RESPONSE_MESSAGE ="Email has been sent successfully ";

}
