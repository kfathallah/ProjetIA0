package com.projetia0;

import com.projetia0.model.Achat;
import com.projetia0.model.Energie;
import com.projetia0.model.Entreprise;
import com.projetia0.model.Transport;
import com.projetia0.service.FacteursEmission;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateurEmpreinteTest {
    @Test
    public void testCalculEmpreinte() {
        Entreprise entreprise = new Entreprise("TestEntreprise");
        entreprise.addPoste(new Energie("Electricité", 1000, FacteursEmission.FACTEUR_ELECTRICITE));
        entreprise.addPoste(new Transport("Train", 500, "train"));
        entreprise.addPoste(new Achat("Achats", 2000, FacteursEmission.FACTEUR_ACHATS));

        double expected = 1000 * FacteursEmission.FACTEUR_ELECTRICITE + 500 * 0.041 + 2000 * FacteursEmission.FACTEUR_ACHATS;
        assertEquals(expected, entreprise.calculerEmpreinte(), 1e-6);
    }

    @Test
    public void testTailleEntreprise() {
        Entreprise entreprise = new Entreprise("PetiteEntreprise");
        entreprise.addPoste(new Energie("Éclairage", 10, FacteursEmission.FACTEUR_ELECTRICITE));

        assertEquals("Petite entreprise", entreprise.tailleEntreprise());
    }
}
