package com.spring.database.digimon;

import com.spring.database.digimon.entity.Digimon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// CRUD 명세
@Mapper
public interface DigimonMapper {

    boolean save(Digimon digimon);
    Digimon findById(Long id);
    List<Digimon> findAll();
    boolean update(Digimon digimon);
    boolean deleteById(Long id);
    int digimonCount();
}


