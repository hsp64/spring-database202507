package com.spring.database.jpa.practiceJpa.repository;

import com.spring.database.jpa.practiceJpa.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
