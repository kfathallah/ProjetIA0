package com.projetia0.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Entreprise {
    private final String nom;
    private final List<PosteEmission> postes;

    public Entreprise(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'entreprise ne peut pas être null ou vide");
        }
        this.nom = nom;
        this.postes = new ArrayList<>();
    }

    public void addPoste(PosteEmission poste) {
        postes.add(poste);
    }

    public double calculerEmpreinte() {
        return postes.stream()
                .mapToDouble(PosteEmission::getEmissionKgCO2)
                .sum();
    }

    public List<PosteEmission> getPostes() {
        return Collections.unmodifiableList(postes);
    }

    public String getNom() {
        return nom;
    }

    public void afficher() {
        System.out.println("Entreprise: " + nom);
        for (PosteEmission poste : postes) {
            System.out.println(" - " + poste.getDescription() + ": " + poste.getEmissionKgCO2() + " kg CO2");
        }
        System.out.println("Empreinte totale: " + calculerEmpreinte() + " kg CO2");
    }

    // calcule de la taille d'entreprise
    public String tailleEntreprise() {
        double empreinte = calculerEmpreinte();
        if (empreinte < 1000) {
            return "Petite entreprise";
        } else if (empreinte < 10000) {
            return "Moyenne entreprise";
        } else {
            return "Grande entreprise";
        }
    }

}
