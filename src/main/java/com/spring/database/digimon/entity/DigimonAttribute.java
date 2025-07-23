package com.spring.database.digimon.entity;

import lombok.Getter;

@Getter
public enum DigimonAttribute {
    VACCINE("Vaccine"),
    DATA("Data"),
    VIRUS("Virus");

    private final String label;

    DigimonAttribute(String label) {
        this.label = label;
    }

}
