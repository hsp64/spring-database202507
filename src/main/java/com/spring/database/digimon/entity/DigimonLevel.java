package com.spring.database.digimon.entity;

import lombok.Getter;

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

}
