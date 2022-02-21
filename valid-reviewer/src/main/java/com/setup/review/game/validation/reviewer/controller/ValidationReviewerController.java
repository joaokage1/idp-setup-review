package com.setup.review.game.validation.reviewer.controller;

import com.setup.review.game.validation.reviewer.service.ValidationReviewerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/validation-reviewer")
public class ValidationReviewerController {

    private final ValidationReviewerService service;

    @GetMapping(path = "{email}")
    public Boolean isValidEmail(@PathVariable("email") String email){
        log.info("Checando email: {}", email);
        return service.isValidEmail(email);
    }
}
