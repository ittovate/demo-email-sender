package com.example.SenderEmail;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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
