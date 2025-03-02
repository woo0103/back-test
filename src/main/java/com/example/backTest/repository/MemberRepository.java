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
    @Autowired
    private final EntityManager em;

    // 회원 저장
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    // 특정 회원 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // 전체 회원 조회
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //


}
