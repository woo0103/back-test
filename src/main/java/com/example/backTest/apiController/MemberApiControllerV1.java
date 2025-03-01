package com.example.backTest.apiController;

import com.example.backTest.domain.Member;
import com.example.backTest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberApiControllerV1 {

    @Autowired
    private final MemberRepository memberRepository;

    // 특정 회원 조회
    @GetMapping("/members/{id}")
    public Member findMember(@PathVariable("id") Long id) {
        return memberRepository.findOne(id)  ;
    }

    // 전체 회원 조회
    @GetMapping("/members")
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }
}
