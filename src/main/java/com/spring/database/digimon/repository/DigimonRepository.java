package com.spring.database.digimon.repository;

import com.spring.database.digimon.entity.Digimon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 역할: 데이터 베이스에 접근해서 CRUD를 수행하는 객체
@RequiredArgsConstructor
@Repository
public class DigimonRepository {

    private final DataSource dataSource;

    // INSERT 기능 - 디지몬 생성
    public boolean save(Digimon digimon) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = """
                    INSERT INTO digimon
                        (name, level, attribute, type, debut_game)
                    VALUES
                        (?, ?, ?, ?, ?)
                    """;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, digimon.getName());
            pstmt.setString(2, digimon.getLevel().getLabel());
            pstmt.setString(3, digimon.getAttribute().getLabel());
            pstmt.setString(4, digimon.getType());
            pstmt.setString(5, digimon.getDebutGame().getLabel());

            int result = pstmt.executeUpdate();
            return result == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 디지몬 이름 타입 변경
    public boolean updateNameAndType(Digimon digimon) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = """
                    UPDATE digimon
                        SET name = ?,
                            type = ?
                        where id = ?
                    """;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, digimon.getName());
            pstmt.setString(2, digimon.getType());
            pstmt.setLong(3, digimon.getId());

            int result = pstmt.executeUpdate();
            return result == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 디지몬 정보 삭제
    public boolean deleteById(Long id) {
        try (Connection conn = dataSource.getConnection()) {

            String sql = """
                    DELETE FROM digimon
                    WHERE id = ?
                    """;

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);

            return pstmt.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 전체 조회 - ORM (Object Relational Mapping)
    public List<Digimon> findAll() {

        List<Digimon> digimonList = new ArrayList<>();

        try (Connection conn = dataSource.getConnection()) {
            String sql = """
                        SELECT * FROM digimon
                    """;

            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) digimonList.add(new Digimon(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return digimonList;
    }

    // id로 단일조회 메서드
    public Digimon findById(Long id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = """
                        SELECT * FROM digimon
                        WHERE id = ?
                    """;

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);

            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) return new Digimon(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
