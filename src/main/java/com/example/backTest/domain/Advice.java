package com.example.backTest.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Advice {
    @Id
    @GeneratedValue
    @Column(name = "advice_id")
    Long id;

    @OneToOne(mappedBy = "advice" , fetch = FetchType.LAZY)
    Diary diary;

    String content;
    LocalDateTime analyzedDate;
    @Enumerated(EnumType.STRING)
    AdviceReaction reaction;
}
