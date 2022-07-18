package dev.hanjoon.lms.banner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hanjoon.lms.banner.entity.Banner;

public interface BannerRepository extends JpaRepository<Banner, Long> {

}
