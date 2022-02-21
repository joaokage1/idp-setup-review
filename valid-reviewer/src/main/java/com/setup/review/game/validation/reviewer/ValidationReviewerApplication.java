package com.setup.review.game.validation.reviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ValidationReviewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidationReviewerApplication.class, args);
    }
}
