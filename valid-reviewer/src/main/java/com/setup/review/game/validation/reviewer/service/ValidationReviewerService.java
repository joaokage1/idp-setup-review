package com.setup.review.game.validation.reviewer.service;

import com.setup.review.game.validation.reviewer.repository.ValidationReviewerRepository;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public record ValidationReviewerService(ValidationReviewerRepository validationReviewerRepository) {

    private static final String REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public Boolean isValidEmail(String email){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
