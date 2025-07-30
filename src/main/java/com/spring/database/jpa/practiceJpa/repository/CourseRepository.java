package com.spring.database.jpa.practiceJpa.repository;

import com.spring.database.jpa.practiceJpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
