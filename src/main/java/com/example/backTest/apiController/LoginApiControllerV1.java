package com.example.backTest.apiController;

import com.example.backTest.Service.LoginService;
import com.example.backTest.Service.MemberService;
import com.example.backTest.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
@Slf4j
public class LoginApiControllerV1 {

    private final MemberService memberService;
    private final LoginService loginService;

    // 로그인
    @PostMapping("/login")
    public void login(@RequestBody Member member, BindingResult bindingResult, HttpServletRequest request) {
        String loginId = member.getLoginId();
        String password = member.getPassword();

        Member loginMember = loginService.authenticate(loginId, password);

        // 인증 실패 시 에러 추가하고 리턴
        if (loginMember == null) {
            bindingResult.reject("login", "아이디, 비밀번호를 다시 입력해주세요");
            return;
        }

        log.info("loginMember={}", loginMember.getName());
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);

    }

    // 로그아웃
    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        // 세션 있으면
        if (session != null) {
                session.invalidate();
        }

    }
}
