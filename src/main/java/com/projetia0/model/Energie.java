package com.projetia0.model;

public class Energie extends PosteEmission {
    private final double quantiteKwh;
    private final double coefficient;

    public Energie(String description, double quantiteKwh, double coefficient) {
        super(description, quantiteKwh * coefficient);
        if (quantiteKwh < 0) {
            throw new IllegalArgumentException("quantiteKwh ne peut pas être négatif: " + quantiteKwh);
        }
        if (coefficient < 0) {
            throw new IllegalArgumentException("coefficient ne peut pas être négatif: " + coefficient);
        }
        this.quantiteKwh = quantiteKwh;
        this.coefficient = coefficient;
    }

    public double getQuantiteKwh() {
        return quantiteKwh;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
