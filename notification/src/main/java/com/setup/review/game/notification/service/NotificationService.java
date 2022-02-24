package com.setup.review.game.notification.service;

import com.setup.review.clients.notification.NotificationRequest;
import com.setup.review.game.notification.model.Notification;
import com.setup.review.game.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(
        NotificationRepository notificationRepository) {

    public void send(NotificationRequest notificationRequest) {

        notificationRepository.save(
                Notification.builder()
                        .toReviewerEmail(notificationRequest.toReviewerEmail())
                        .sender("gameReviewer@gmail.com")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
