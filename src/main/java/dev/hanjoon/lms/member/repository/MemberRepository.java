package dev.hanjoon.lms.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hanjoon.lms.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
    Optional<Member> findByEmailAuthKey(String emailAuthKey);
    Optional<Member> findByUserIdAndUserName(String userId, String userName);
}
