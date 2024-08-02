package com.example.SenderEmail;


import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Demo Email Sender",
                description = "Very basic Demo",
                contact = @Contact(
                        email = "mostafadfrg@gmail.com",
                        name = "Mostafa Hussein"
                ),
                version = "0.0.1"
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Development Server")
        }
)
@EnableAsync
public class SenderEmailApplication {

    public static void main(String[] args) {


        // Add Environment Variables to the application context before start
        Dotenv dotenv = Dotenv.load();
        for (DotenvEntry entry : dotenv.entries()) {
            System.setProperty(entry.getKey(), entry.getValue());
        }

        // Start the application

        SpringApplication.run(SenderEmailApplication.class, args);
    }


}
