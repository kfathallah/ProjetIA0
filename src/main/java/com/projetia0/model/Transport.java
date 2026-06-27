package com.projetia0.model;

import com.projetia0.service.FacteursEmission;

public class Transport extends PosteEmission {
    private final double distanceKm;
    private final String mode;

    public Transport(String description, double distanceKm, String mode) {
        if (distanceKm < 0) {
            throw new IllegalArgumentException("distanceKm ne peut pas être négatif: " + distanceKm);
        }
        if (mode == null || mode.trim().isEmpty()) {
            throw new IllegalArgumentException("mode de transport ne peut pas être null ou vide");
        }
        super(description, distanceKm * FacteursEmission.getTransportFactor(mode));
        this.distanceKm = distanceKm;
        this.mode = mode;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public String getMode() {
        return mode;
    }
}
