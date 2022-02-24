package com.setup.review.clients.notification;

public record NotificationRequest(
        String toReviewerEmail,
        String message) {
}
