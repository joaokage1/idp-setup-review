package com.setup.review.game.notification.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document
public class Notification {

    @Id
    private String notificationId;
    private String toReviewerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}
