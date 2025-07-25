package com.spring.database.digimon;

import com.spring.database.digimon.entity.Digimon;
import com.spring.database.digimon.entity.DigimonAttribute;
import com.spring.database.digimon.entity.DigimonDebutGame;
import com.spring.database.digimon.entity.DigimonLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DigimonMapperTest {

    @Autowired DigimonMapper digimonMapper;

    @Test
    @DisplayName("save test")
    void saveTest() {
        //given
        Digimon newDigimon = Digimon.builder()
                .name("피카츄")
                .level(DigimonLevel.valueOf("ROOKIE"))
                .attribute(DigimonAttribute.valueOf("VACCINE"))
                .type("electronic")
                .debutGame(DigimonDebutGame.valueOf("ADVENTURE"))
                .build();
        //when
        boolean save = digimonMapper.save(newDigimon);
        //then
        assertTrue(save);
    }

    @Test
    @DisplayName("update test")
    void updateTest() {
        //given
        Digimon updateDigimon = Digimon.builder()
                .name("피카츄")
                .level(DigimonLevel.valueOf("ROOKIE"))
                .attribute(DigimonAttribute.valueOf("VACCINE"))
                .type("electronic")
                .debutGame(DigimonDebutGame.valueOf("DELETED"))
                .id(18L)
                .build();
        //when
            boolean update = digimonMapper.update(updateDigimon);
        //then
        assertTrue(update);
    }

    @Test
    @DisplayName("delete test")
    void deleteTest() {
        //given
        Long id = 7L;
        //when
        boolean b = digimonMapper.deleteById(id);
        //then
        assertTrue(b);
    }

    @Test
    @DisplayName("findAll test")
    void findAllTest() {
        //given

        //when
        List<Digimon> digimonList = digimonMapper.findAll();
        //then
        digimonList.forEach(System.out::println);
        assertEquals(12, digimonList.size());
    }

    @Test
    @DisplayName("findOne test")
    void findOneTest() {
        //given
        Long id = 4L;
        //when
        Digimon foundDigimon = digimonMapper.findById(id);
        //then
        System.out.println("foundDigimon = " + foundDigimon);
        assertEquals("가트몬", foundDigimon.getName());
    }

    // delete 제외 카운트
    @Test
    @DisplayName("count test")
    void countTest() {
        //given

        //when
        int count = digimonMapper.digimonCount();
        //then
        assertEquals(10, count);
    }





}