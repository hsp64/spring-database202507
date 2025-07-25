package com.spring.database.digimon.repository;

import com.spring.database.digimon.entity.Digimon;
import com.spring.database.digimon.entity.DigimonAttribute;
import com.spring.database.digimon.entity.DigimonDebutGame;
import com.spring.database.digimon.entity.DigimonLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.spring.database.digimon.entity.Digimon.builder;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DigimonRepositoryTest {

    @Autowired
    DigimonRepository digimonRepository;


    @Test
    @DisplayName("디지몬 정보를 주면 데이터베이스 digimon에 저장된다.")
    public void saveTest() {
        //given
        List<Digimon> digimonList = List.of(
                Digimon.builder()
                        .name("고유값몬투XN")
                        .level(DigimonLevel.valueOf("CHAMPION"))
                        .attribute(DigimonAttribute.valueOf("VACCINE"))
                        .type("공유")
                        .debutGame(DigimonDebutGame.valueOf("ADVENTURE"))
                        .build()
        );
        //when
        for (Digimon digimon : digimonList) {
            digimonRepository.save(digimon);
        }
        //then
    }

    @Test
    @DisplayName("디지몬이름과 타입을 수정한다.")
    public void updateTest() {
        //given
        Digimon updateDigimon = Digimon.builder()
                .name("테스트뚜리몬")
                .level(DigimonLevel.valueOf("ROOKIE"))
                .attribute(DigimonAttribute.valueOf("VACCINE"))
                .type("변경")
                .debutGame(DigimonDebutGame.valueOf("ADVENTURE"))
                .id(13L)
                .build();
        //when
        digimonRepository.updateNameAndType(updateDigimon);
        //then
    }

    @Test
    @DisplayName("id를 주면 digimon 테이블에서 해당 id를 가진 행이 삭제된다.")
    public void deleteTest() {
        //given
        Long id = 14L;
        //when
        digimonRepository.deleteById(id);
        //then
    }


    @Test
    @DisplayName("전체조회를 하면 디지몬의 리스트가 반환된다.")
    public void findAllTest() {
        //given

        //when
        List<Digimon> digimonList = digimonRepository.findAll();
        //then
        digimonList.forEach(System.out::println);

        assertEquals(5, digimonList.size());
        assertNotNull(digimonList.get(0));
        assertEquals("Agumon", digimonList.get(0).getName());
    }
//
//    @Test
//    @DisplayName("적합한 id를 통해 개별조회를 하면 해당 디지몬 id의 객체가 반환된다.")
//    public void findOneTest() {
//        //given
//        Long givenId = 6L;
//        //when
//        Digimon foundDigimon = digimonRepository.findById(givenId);
//        //then
//        System.out.println("foundDigimon = " + foundDigimon);
//        assertNotNull(foundDigimon);
//        assertEquals("파닥몬", foundDigimon.getName());
//    }
//
}