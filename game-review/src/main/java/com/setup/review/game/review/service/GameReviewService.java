package com.setup.review.game.review.service;

import com.setup.review.amqp.RabbitMQMessageProducer;
import com.setup.review.clients.notification.NotificationRequest;
import com.setup.review.clients.valid.reviewer.IValidReviewerClient;
import com.setup.review.game.review.dto.GameReviewRequest;
import com.setup.review.game.review.dto.GameReviewResponse;
import com.setup.review.game.review.model.GameReview;
import com.setup.review.game.review.repository.GameReviewRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class GameReviewService {

    private final GameReviewRepository repository;
    private final IValidReviewerClient validReviewerClient;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    public GameReviewResponse registerGameReview(GameReviewRequest request){

        repository.deleteAll();
        GameReview gameReview = GameReview.builder()
                .gameName(request.gameName())
                .email(request.gameName())
                .description(request.description())
                .email(request.email()).build();

        Boolean validEmail = validReviewerClient.isValidEmail(gameReview.getEmail());
        gameReview.setIsValidEmail(validEmail);
        //TODO: Enviar notificação para o reviewer.

        repository.save(gameReview);
        log.info(String.format("Saved review of: %s from: %s", gameReview.getGameName(), gameReview.getEmail()));

        if (!validEmail) {
            throw new IllegalStateException("Email not valid");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                gameReview.getEmail(),
                String.format("Hi %s, welcome to Game Review...",
                        gameReview.getEmail())
        );

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );

        return new GameReviewResponse("Thank you for your review!!");
    }

    public Integer fetchReviewNumberFromEmail(String email){
        return repository.findAllByEmail(email).size();
    }
}
