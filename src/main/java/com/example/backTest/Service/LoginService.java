package com.example.backTest.Service;

import com.example.backTest.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final MemberService memberService;

    /**
     *
     * @param loginId
     * @param password
     * @return 로그인한 멤버 반환함(실패하면 null)
     */
    public Member authenticate(String loginId, String password) {
        Member member = memberService.getMember(loginId);
        // 아이디, 비밀번호가 일치하는 경우 member 반환
        // 일치하지 않는 경우 null
        if (member != null) {
            if (password.equals(member.getPassword())) {
                return member;
            }
        }
        log.info("loginId={}, password={}", loginId, password);
        return null;
    }

}
