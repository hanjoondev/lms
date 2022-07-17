package dev.hanjoon.lms.course.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hanjoon.lms.course.entity.TakeCourse;

public interface TakeCourseRepository extends JpaRepository<TakeCourse, Long> {
    long countByCourseIdAndUserIdAndStatusIn(long courseId, String userId, Collection<String> statusList);
}
