package com.spring.database.digimon.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum DigimonDebutGame {
    ADVENTURE("Digimon Adventure"),
    WORLD("Digimon World"),
    TAMERS("Digimon Tamers");

    private final String label;

    DigimonDebutGame(String label) {
        this.label = label;
    }

    @JsonCreator
    public static DigimonDebutGame from(String value) {
        return Arrays.stream(DigimonDebutGame.values())
                .filter(e -> e.label.equalsIgnoreCase(value) || e.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown debut game: " + value));
    }

}