package com.setup.review.game.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GameReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameReviewApplication.class,args);
    }
}
