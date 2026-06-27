package com.projetia0.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FacteursEmissionTest {

    @Test
    public void testGetTransportFactorKnownMode() {
        assertEquals(0.172, FacteursEmission.getTransportFactor("voiture"), 1e-6);
        assertEquals(0.041, FacteursEmission.getTransportFactor("train"), 1e-6);
        assertEquals(0.254, FacteursEmission.getTransportFactor("avion"), 1e-6);
    }

    @Test
    public void testGetTransportFactorUnknownModeReturnsZero() {
        assertEquals(0.0, FacteursEmission.getTransportFactor("bicyclette"), 1e-6);
    }

    @Test
    public void testGetTransportFactorIsCaseInsensitive() {
        assertEquals(0.041, FacteursEmission.getTransportFactor("TrAiN"), 1e-6);
    }
}
