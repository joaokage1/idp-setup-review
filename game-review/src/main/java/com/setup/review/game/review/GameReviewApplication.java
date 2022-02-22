package com.setup.review.game.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.setup.review.clients")
public class GameReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameReviewApplication.class,args);
    }
}
