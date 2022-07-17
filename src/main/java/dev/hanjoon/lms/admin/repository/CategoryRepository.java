package dev.hanjoon.lms.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hanjoon.lms.admin.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
