package com.example.backTest.repository;

import com.example.backTest.domain.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class MemberRepository {
    private final EntityManager em;

    // 회원 저장
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    // 특정 회원 조회
    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    // 로그인 아이디로 조회
    public Member findByLoginId(String loginId) {
        List<Member> member = em.createQuery("select m from Member m where m.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId)
                .getResultList();
        return member.isEmpty() ? null : member.get(0);
    }

    // 전체 회원 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    // 회원 삭제
    public void delete(Member member) {
        // 1. 엔티티가 영속 상태가 아니라면, 먼저 영속 상태로 만들어야 함.
        Member deleteMember = em.find(Member.class, member.getId());  // 영속성 컨텍스트에서 조회
        if (deleteMember != null) {
            em.remove(deleteMember);  // 영속 상태인 엔티티 삭제
        }
    }

    // 회원 삭제
    public void deleteById(Long id) {
        Member deleteMember = em.find(Member.class, id);
        if (deleteMember != null) {
            em.remove(deleteMember);  // 영속 상태인 엔티티 삭제
        }
    }




}
