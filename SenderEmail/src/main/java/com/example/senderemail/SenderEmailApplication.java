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

import static com.example.senderemail.constant.SwaggerConstant.*;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = TITLE,
                description = DESCRIPTION,
                contact = @Contact(
                        email = CONTACT_EMAIL,
                        name = CONTACT_NAME,
                        url = CONTACT_URL
                ),
                version = VERSION
        ),
        servers = {
                @Server(url = DEVELOPMENT_SERVER_URL, description = DEVELOPMENT_SERVER_DESCRIPTION)
        }
)
@EnableAsync
public class SenderEmailApplication {
    /**
     * @param args
     */
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
