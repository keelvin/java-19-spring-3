package br.com.kelvin.java19spring3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(
    exclude = {
        SecurityAutoConfiguration.class,
    }
)
public class Java19Spring3Application {

    public static void main(String[] args) {
        SpringApplication.run(Java19Spring3Application.class, args);
    }

}
