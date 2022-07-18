package dev.hanjoon.lms.history.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.hanjoon.lms.history.entity.LoginHistory;
import dev.hanjoon.lms.history.repository.LoginHistoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class LoginHistoryService {
    private final LoginHistoryRepository loginHistoryRepository;

    public boolean save(LoginHistory loginHistory) {
        loginHistoryRepository.save(loginHistory);
        return true;
    }

    public List<LoginHistory> getHistories(String userId) {
        return loginHistoryRepository.findByUserId(userId);
    }
}
