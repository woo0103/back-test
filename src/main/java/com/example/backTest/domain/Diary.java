package com.example.backTest.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Diary {

    @Id
    @GeneratedValue
    @Column(name = "diary_id")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    Member member;
    String content;
    LocalDateTime createDate;
    LocalDateTime updateDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emotion_id")
    Emotion emotion;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advice_id")
    Advice advice;
}
