package com.setup.review.game.validation.reviewer.repository;

import com.setup.review.game.validation.reviewer.model.ValidationReviewer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationReviewerRepository extends MongoRepository<ValidationReviewer, String> {
}
