package com.spring.database.jpa.practiceJpa.repository;

import com.spring.database.jpa.practiceJpa.entity.Course;
import com.spring.database.jpa.practiceJpa.entity.Enrollment;
import com.spring.database.jpa.practiceJpa.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class EnrollmentRepositoryTest {

    @Autowired StudentRepository studentRepository;
    @Autowired CourseRepository courseRepository;
    @Autowired EnrollmentRepository enrollmentRepository;

    @Autowired
    EntityManager em;

    // 학생 2, 강의 2, 수강신청 3
    private Student student1;
    private Student student2;
    private Course course1;
    private Course course2;
    private Enrollment enrollment1;
    private Enrollment enrollment2;
    private Enrollment enrollment3;

    @BeforeEach
    void setUp() {
        student1 = Student.builder()
                .name("김철수")
                .email("kim@cheol.su")
                .build();
        student2 = Student.builder()
                .name("하츄핑")
                .email("ha@chu.ping")
                .build();
        course1 = Course
                .builder()
                .title("사막에서 살아남기")
                .instructor("노빈손")
                .price(15000)
                .build();
        course2 = Course
                .builder()
                .title("어른왕자")
                .instructor("돈땃지베리")
                .price(10000)
                .build();

        enrollment1 = Enrollment.builder()
                .student(student1)
                .course(course1)
                .progressRate(50)
                .completed(false)
                .build();

        studentRepository.saveAllAndFlush(
                List.of(student1, student2));
        courseRepository.saveAllAndFlush(
                List.of(course1, course2));
    }

}