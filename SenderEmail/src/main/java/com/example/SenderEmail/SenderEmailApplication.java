package com.example.SenderEmail;

import com.example.SenderEmail.service.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

@SpringBootApplication
public class SenderEmailApplication {
	private EmailService emailService ;

	public SenderEmailApplication(EmailService emailService) {
		this.emailService = emailService;
	}

	public static void main(String[] args) {
		// SpringApplication.run(SenderEmailApplication.class, args);

		ApplicationContext context = SpringApplication.run(SenderEmailApplication.class , args) ;
		SenderEmailApplication app = context.getBean(SenderEmailApplication.class) ;
		app.Run();
	}

	private void Run(){

		ArrayList<String > receivers = new ArrayList<>( ) ;
		receivers.add("mostafahass314@gmail.com" ) ;
		receivers.add("mustafa.2buelmagd@gmail.com") ;
		emailService.sendEmail(  new ArrayList<>( )   , "The first Email " , "This is a body welcome to ") ;
	}

}
