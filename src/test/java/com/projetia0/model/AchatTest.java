package com.projetia0.model;

import com.projetia0.service.FacteursEmission;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AchatTest {

    @Test
    public void testAchatCalculEmission() {
        Achat achat = new Achat("Achats de bureau", 1500, FacteursEmission.FACTEUR_ACHATS);

        assertEquals("Achats de bureau", achat.getDescription());
        assertEquals(1500, achat.getMontantEuros(), 1e-6);
        assertEquals(FacteursEmission.FACTEUR_ACHATS, achat.getCoefficient(), 1e-6);
        assertEquals(1500 * FacteursEmission.FACTEUR_ACHATS, achat.getEmissionKgCO2(), 1e-6);
    }
}
