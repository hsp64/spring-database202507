package com.spring.database.digimon.entity;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Digimon {

    private Long id;
    private String name;
    private DigimonLevel level;
    private DigimonAttribute attribute;
    private String type;
    private DigimonDebutGame debutGame;
    private LocalDateTime createdAt;

    public Digimon(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getLong("id");
        this.name = resultSet.getString("name");
        this.level = DigimonLevel.valueOf(resultSet.getString("level"));
        this.attribute = DigimonAttribute.valueOf(resultSet.getString("attribute"));
        this.type = resultSet.getString("type");
        this.debutGame = DigimonDebutGame.valueOf(resultSet.getString("debut_game"));
        this.createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
    }
}
