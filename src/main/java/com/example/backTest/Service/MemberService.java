package com.example.backTest.Service;

import com.example.backTest.domain.Member;
import com.example.backTest.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 가입
    public Long join(Member member) {
        return memberRepository.save(member);
    }

    // 전체 회원 조회
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // 특정 회원 조회
    public Member getMember(Long id) {
        return memberRepository.findById(id);
    }

    public Member getMember(String loginId) {
        return memberRepository.findByLoginId(loginId);
    }


    // 회원 삭제 by id
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    // 회원 삭제
    public void deleteMember(Member member) {
        memberRepository.delete(member);
    }
}
