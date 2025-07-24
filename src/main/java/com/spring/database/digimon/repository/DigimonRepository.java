package com.spring.database.digimon.repository;

import com.spring.database.chap02.entity.Product;
import com.spring.database.digimon.entity.Digimon;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.beans.BeanProperty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 역할: 데이터 베이스에 접근해서 CRUD를 수행하는 객체
@RequiredArgsConstructor
@Repository
public class DigimonRepository {

    private final JdbcTemplate template;

    // INSERT 기능 - 디지몬 생성
    public void save(Digimon digimon) {
        String sql = """
                INSERT INTO digimon
                    (name, level, attribute, type, debut_game)
                VALUES
                    (?, ?, ?, ?, ?)
                """;
        template.update(sql,
                digimon.getName(),
                digimon.getLevel().toString(),
                digimon.getAttribute().toString(),
                digimon.getType(),
                digimon.getDebutGame().toString()
        );
    }


    // 디지몬 이름 타입 변경
    public void updateNameAndType(Digimon digimon) {
        String sql = """
                UPDATE digimon
                    SET name = ?,
                        level = ?,
                        attribute = ?,
                        type = ?,
                        debut_game = ?
                    where id = ?
                """;
        template.update(sql,
                digimon.getName(),
                digimon.getLevel(),
                digimon.getAttribute(),
                digimon.getType(),
                digimon.getDebutGame(),
                digimon.getId()
        );

    }


    // 디지몬 정보 삭제(논리 삭제)
    public void deleteById(Long id) {
            String sql = """
                    UPDATE FROM digimon
                        SET debut_game = 'DELETED'
                    WHERE id = ?
                    """;
            template.update(sql, id);
    }

    // 전체 조회
    public List<Digimon> findAll() {
            String sql = """
                    SELECT * FROM digimon
                    WHERE debut_game <> 'DELETED'
                    """;
            return template.query(sql, new BeanPropertyRowMapper<>(Digimon.class));
    }

    // id로 단일조회 메서드
    public Digimon findById(Long id) {
        String sql = """
            SELECT * FROM digimon
            WHERE id = ?
            """;

        return template.queryForObject(sql, (rs, rowNum) -> new Digimon(rs), id);
    }

}
