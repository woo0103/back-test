package com.example.backTest.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Emotion {

    @Id
    @GeneratedValue
    @Column(name = "emotion_id")
    Long id;

    @OneToOne(mappedBy = "emotion")
    Diary diary;
    String type;
    Double intensity;
    LocalDateTime analyzedDate;
}
