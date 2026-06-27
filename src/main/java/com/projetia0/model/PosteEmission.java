package com.projetia0.model;

public abstract class PosteEmission {
    private final String description;
    private final double emissionKgCO2;

    protected PosteEmission(String description, double emissionKgCO2) {
        this.description = description;
        this.emissionKgCO2 = emissionKgCO2;
    }

    public String getDescription() {
        return description;
    }

    public double getEmissionKgCO2() {
        return emissionKgCO2;
    }
}
