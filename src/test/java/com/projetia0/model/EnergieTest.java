package com.projetia0.model;

import com.projetia0.service.FacteursEmission;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnergieTest {

    @Test
    public void testEnergieCalculEmission() {
        Energie energie = new Energie("Électricité", 1000, FacteursEmission.FACTEUR_ELECTRICITE);

        assertEquals("Électricité", energie.getDescription());
        assertEquals(1000, energie.getQuantiteKwh(), 1e-6);
        assertEquals(FacteursEmission.FACTEUR_ELECTRICITE, energie.getCoefficient(), 1e-6);
        assertEquals(1000 * FacteursEmission.FACTEUR_ELECTRICITE, energie.getEmissionKgCO2(), 1e-6);
    }
}
