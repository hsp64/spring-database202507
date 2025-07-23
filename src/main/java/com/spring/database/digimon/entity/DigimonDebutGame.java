package com.spring.database.digimon.entity;

import lombok.Getter;

@Getter
public enum DigimonDebutGame {
    ADVENTURE("Digimon Adventure"),
    WORLD("Digimon World"),
    TAMERS("Digimon Tamers");

    private final String label;

    DigimonDebutGame(String label) {
        this.label = label;
    }

}