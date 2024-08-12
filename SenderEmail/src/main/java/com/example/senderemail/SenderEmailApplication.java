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

    public static void loadDotenv(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("#")) {
                    String[] parts = line.split("=", 2);
                    if (parts.length == 2) {
                        String key = parts[0].trim();
                        String value = parts[1].trim();
                        System.out.println("key:::  " + key + "    value:: " + value);
                        System.setProperty(key, value);
                    }
                }
            }
        }
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
//        try {
//            // Adjust the path to your .env file
//            loadDotenv(args[0] + ".env");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Set<Map.Entry<String, String>> envVars = System.getenv().entrySet();
        System.out.println("env vars :: :: :" + envVars);

//        String[] keys = (String[]) envVars.keySet().toArray();
        for (int i = 0; i < envVars.size(); i++) {
            String key = envVars.toArray()[i].toString().split("=")[0];
            String value = envVars.toArray()[i].toString().split("=")[1];
            System.out.println("Key:::: " + key + "    Value::: " + value);
        }

        // Add Environment Variables to the application context before start
//        Dotenv dotenv = Dotenv.load();
//        for (DotenvEntry entry : dotenv.entries()) {
//            System.out.println("KEY :::: " + entry.getKey() + "   VALUE:::: " + entry.getValue());
//            System.setProperty(entry.getKey(), entry.getValue());
//        }

        // Start the application

        SpringApplication.run(SenderEmailApplication.class, args);
    }


}
