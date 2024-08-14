package com.example.senderemail;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
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

    /**
     * @param args
     */
    public static void main(String[] args) {

        SpringApplication.run(SenderEmailApplication.class, args);
    }


}
