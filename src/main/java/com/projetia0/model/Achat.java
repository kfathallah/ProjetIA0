package com.projetia0.model;

public class Achat extends PosteEmission {
    private final double montantEuros;
    private final double coefficient;

    public Achat(String description, double montantEuros, double coefficient) {
        super(description, montantEuros * coefficient);
        if (montantEuros < 0) {
            throw new IllegalArgumentException("montantEuros ne peut pas être négatif: " + montantEuros);
        }
        if (coefficient < 0) {
            throw new IllegalArgumentException("coefficient ne peut pas être négatif: " + coefficient);
        }
        this.montantEuros = montantEuros;
        this.coefficient = coefficient;
    }

    public double getMontantEuros() {
        return montantEuros;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
