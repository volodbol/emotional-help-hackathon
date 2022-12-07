package com.epam.hackathon.emotional.help;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Emotional Help API",
        version = "1.0",
        description = "Emotional Help Project Api Information"))
public class EmotionalHelpApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmotionalHelpApplication.class, args);
    }

}
