package com.example.senderemail;


import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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


        Set<Map.Entry<String, String>> envVars = System.getenv().entrySet();

        for (int i = 0; i < envVars.size(); i++) {
            String key = envVars.toArray()[i].toString().split("=")[0];
            String value = envVars.toArray()[i].toString().split("=")[1];
            System.out.println("Key:::: " + key + "    Value::: " + value);
        }
        System.out.println("\n\n\n\n\n\n\n\n\n");

        SpringApplication.run(SenderEmailApplication.class, args);
    }


}
