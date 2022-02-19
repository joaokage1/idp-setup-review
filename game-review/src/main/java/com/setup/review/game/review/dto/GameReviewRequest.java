package com.setup.review.game.review.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;

public record GameReviewRequest(
        @Email(message = "Need a valid email")
        String email,
        String gameName,
        @DecimalMax(value = "10.0", message = "Max value is 10.0")
        @DecimalMin(value = "0.0", message = "Min value is 0.0")
        Long score,
        String description) {
}
