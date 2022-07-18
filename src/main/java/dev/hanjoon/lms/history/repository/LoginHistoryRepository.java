package dev.hanjoon.lms.history.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hanjoon.lms.history.entity.LoginHistory;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
    List<LoginHistory> findByUserId(String userId);
}
