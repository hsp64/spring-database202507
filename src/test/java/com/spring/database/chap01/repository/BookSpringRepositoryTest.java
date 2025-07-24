package com.spring.database.chap01.repository;

import com.spring.database.chap01.entity.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookSpringRepositoryTest {


    @Autowired
    private BookSpringRepository bookSpringRepository;

    @Test
    @DisplayName("스프링 JDBC로 도서를 생성한다")
    void saveTest() {
        //given
        Book newBook = Book.builder()
                .title("스프링 JDBC")
                .author("자바왕")
                .isbn("S001")

                .build();
        //when
        boolean flag = bookSpringRepository.save(newBook);
        //then

    }

    @Test
    @DisplayName("Spring jdbc로 수정")
    void updateTest() {
        //given
        Book updatedBook = Book.builder()
                .title("수정된 책")
                .author("수정된 저자명")
                .id(6L)
                .build();
        //when
        boolean flag = bookSpringRepository.updateTitleAndAuthor(updatedBook);
        //then
        assertTrue(flag);
    }


    @Test
    @DisplayName("Spring jdbc로 도서 삭제")
    void deleteTest() {
        //given
        Long givenId = 5L;
        //when
        boolean flag = bookSpringRepository.deleteById(givenId);
        //then
        assertTrue(flag);
    }

}

