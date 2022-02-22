package com.setup.review.clients.valid.reviewer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("validation-reviewer")
public interface IValidReviewerClient {

    @GetMapping(path = "/api/v1/validation-reviewer/{email}")
    public Boolean isValidEmail(@PathVariable("email") String email);
}
