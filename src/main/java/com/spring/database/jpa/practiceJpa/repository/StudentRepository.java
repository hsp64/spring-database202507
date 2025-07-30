package com.spring.database.jpa.practiceJpa.repository;

import com.spring.database.jpa.practiceJpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
