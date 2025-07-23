package com.spring.database.digimon.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum DigimonLevel {
    ROOKIE("Rookie"),
    CHAMPION("Champion"),
    ULTIMATE("Ultimate"),
    MEGA("Mega");


    private final String label;

    DigimonLevel(String label) {
        this.label = label;
    }

    @JsonCreator
    public static DigimonLevel from(String value) {
        return Arrays.stream(DigimonLevel.values())
                .filter(e -> e.label.equalsIgnoreCase(value) || e.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown level: " + value));
    }
}
