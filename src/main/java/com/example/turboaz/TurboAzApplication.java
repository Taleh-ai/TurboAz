package com.example.turboaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TurboAzApplication {

    public static void main(String[] args) {
        SpringApplication.run(TurboAzApplication.class, args);
    }

}
