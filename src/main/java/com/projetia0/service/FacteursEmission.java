package com.projetia0.service;

import java.util.HashMap;
import java.util.Map;

public class FacteursEmission {
    public static final double FACTEUR_ELECTRICITE = 0.058;
    public static final double FACTEUR_ACHATS = 0.15;

    private static final Map<String, Double> TRANSPORT_FACTEURS = new HashMap<>();

    static {
        TRANSPORT_FACTEURS.put("voiture", 0.172);
        TRANSPORT_FACTEURS.put("train", 0.041);
        TRANSPORT_FACTEURS.put("avion", 0.254);
    }

    public static double getTransportFactor(String mode) {
        if (mode == null) {
            throw new IllegalArgumentException("Le mode de transport ne peut pas être null");
        }
        String normalizedMode = mode.toLowerCase();
        if (!TRANSPORT_FACTEURS.containsKey(normalizedMode)) {
            throw new IllegalArgumentException("Mode de transport non reconnu: " + mode + ". Modes valides: voiture, train, avion");
        }
        return TRANSPORT_FACTEURS.get(normalizedMode);
    }
}
