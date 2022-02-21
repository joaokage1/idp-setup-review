package com.setup.review.game.review.controller;

import com.setup.review.game.review.dto.GameReviewRequest;
import com.setup.review.game.review.dto.GameReviewResponse;
import com.setup.review.game.review.service.GameReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1/game/review")
public record GameReviewController(GameReviewService gameReviewService) {

    @PostMapping
    public ResponseEntity<GameReviewResponse> registerGameReview(@Valid @RequestBody GameReviewRequest request){
        log.info("new game review registration {}", request);

        return ResponseEntity.ok(gameReviewService.registerGameReview(request));
    }

    @GetMapping(path = "/{email}")
    public ResponseEntity<String> fetchReviewNumberFromEmail(@PathVariable String email) {
        log.info("Searching all the reviews from {}", email);

        return ResponseEntity.ok(String.format("All reviews: %s", gameReviewService.fetchReviewNumberFromEmail(email)));
    }
}
