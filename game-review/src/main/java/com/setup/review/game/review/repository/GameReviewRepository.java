package com.setup.review.game.review.repository;

import com.setup.review.game.review.model.GameReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameReviewRepository extends MongoRepository<GameReview,String> {

    List<GameReview> findAllByEmail(String email);
}
