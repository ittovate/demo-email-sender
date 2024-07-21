package com.example.SenderEmail;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "Demo Email Sender",
                description = "Very basic Demo",
                contact = @Contact(
                        email = "mostafadfrg@gmail.com",
                        name = "Mostafa Hussein"
                ),
                version = "0.0.1"
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Development Server")
        },
        extensions = {
                @Extension(name = "scanAllResources",
                        properties = @ExtensionProperty(name = "scanAllResources", value = "false")
                )
        }

)
public class SenderEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(SenderEmailApplication.class, args);
    }


}
