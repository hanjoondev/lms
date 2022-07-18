package dev.hanjoon.lms.history.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.hanjoon.lms.history.entity.LoginHistory;
import dev.hanjoon.lms.history.repository.LoginHistoryRepository;
import dev.hanjoon.lms.member.entity.Member;
import dev.hanjoon.lms.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginHistoryService {
    private final LoginHistoryRepository loginHistoryRepository;
    private final MemberRepository memberRepository;

    public boolean save(LoginHistory loginHistory) {
        loginHistoryRepository.save(loginHistory);
        Member member = memberRepository.findById(loginHistory.getUserId()).get();
        member.setLastLoginDt(loginHistory.getTime());
        memberRepository.save(member);
        return true;
    }

    public List<LoginHistory> getHistories(String userId) {
        return loginHistoryRepository.findByUserId(userId);
    }
}
