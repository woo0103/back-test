package com.example.backTest.apiController;

import com.example.backTest.domain.Member;
import com.example.backTest.repository.MemberRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberApiControllerV1 {

    @Autowired
    private final MemberRepository memberRepository;

    // 특정 회원 조회
    @GetMapping("/members/{id}")
    public Member findMember(@PathVariable("id") Long id, HttpServletResponse response) {
        Member member = memberRepository.findOne(id);
        if (member == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return member;
    }

    // 전체 회원 조회
    @GetMapping("/members")
    public List<Member> findMembers() {

        return memberRepository.findAll();
    }

    // 회원가입
    @PostMapping("/members")
    public Long joinMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }
}
