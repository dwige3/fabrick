package it.fabrick.bip.wwsbipbackend;

import it.fabrick.bip.wwsbipbackend.converter.ConvertionServiceAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConvertionServiceAutoConfiguration.class)
@SpringBootApplication
public class FabrickWwsCashManagementBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FabrickWwsCashManagementBeApplication.class, args);
    }

}
