package com.example.backTest.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    Long id;

    String name;
    String email;
    String password;
    String nickName;
    @Enumerated(EnumType.STRING)
    Role Role;
    LocalDateTime createDate;
    LocalDate birthDate;
    String phone;
    String profilPicture;

    @OneToMany(mappedBy = "member")
    List<Diary> diaries = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
    }




}
