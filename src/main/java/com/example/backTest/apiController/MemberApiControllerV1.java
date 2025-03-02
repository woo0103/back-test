package com.example.backTest.apiController;

import com.example.backTest.Service.MemberService;
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
@RequestMapping("/api/v1/members")
public class MemberApiControllerV1 {

    private final MemberService memberService;

    // 회원가입
    @PostMapping
    public Long joinMember(@RequestBody Member member) {
        return memberService.join(member);
    }

    // 특정 회원 조회
    @GetMapping("/{id}")
    public Member getMember(@PathVariable("id") Long id, HttpServletResponse response) {
        Member member = memberService.getMember(id);
        if (member == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return member;
    }

    // 전체 회원 조회
    @GetMapping
    public List<Member> getAllMembers() {

        return memberService.getAllMembers();
    }

    // 회원 삭제
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);
    }

}
