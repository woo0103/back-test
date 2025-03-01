package com.example.backTest.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Feedback {

    @Id
    @GeneratedValue
    @Column(name = "feedback_id")
    Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    Member user;

    String request;
    @Enumerated(EnumType.STRING)
    FeedbackType feedbackType;
    @Enumerated(EnumType.STRING)
    FeedbackStatus status;
    LocalDateTime requestDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    Member admin;
    String response;
    LocalDateTime responseDate;


}
