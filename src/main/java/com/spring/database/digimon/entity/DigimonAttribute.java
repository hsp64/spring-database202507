package com.spring.database.digimon.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum DigimonAttribute {
    VACCINE("Vaccine"),
    DATA("Data"),
    VIRUS("Virus");

    private final String label;

    DigimonAttribute(String label) {
        this.label = label;
    }

    @JsonCreator
    public static DigimonAttribute from(String value) {
        return Arrays.stream(DigimonAttribute.values())
                .filter(e -> e.label.equalsIgnoreCase(value) || e.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown attribute: " + value));
    }
}
