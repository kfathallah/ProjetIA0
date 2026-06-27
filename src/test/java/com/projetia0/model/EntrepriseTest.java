package com.projetia0.model;

import com.projetia0.service.FacteursEmission;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EntrepriseTest {

    @Test
    public void testCalculerEmpreinteVide() {
        Entreprise entreprise = new Entreprise("Vide");
        assertEquals(0.0, entreprise.calculerEmpreinte(), 1e-6);
    }

    @Test
    public void testAddPosteAndCalculerEmpreinte() {
        Entreprise entreprise = new Entreprise("MonEntreprise");
        entreprise.addPoste(new Energie("Electricité", 1000, FacteursEmission.FACTEUR_ELECTRICITE));
        entreprise.addPoste(new Transport("Train", 500, "train"));
        entreprise.addPoste(new Achat("Achats", 2000, FacteursEmission.FACTEUR_ACHATS));

        double expected = 1000 * FacteursEmission.FACTEUR_ELECTRICITE
                + 500 * FacteursEmission.getTransportFactor("train")
                + 2000 * FacteursEmission.FACTEUR_ACHATS;

        assertEquals(expected, entreprise.calculerEmpreinte(), 1e-6);
    }

    @Test
    public void testGetPostesReturnsUnmodifiableList() {
        Entreprise entreprise = new Entreprise("Test");
        entreprise.addPoste(new Energie("Electricité", 100, FacteursEmission.FACTEUR_ELECTRICITE));
        List<PosteEmission> postes = entreprise.getPostes();

        assertThrows(UnsupportedOperationException.class, () -> postes.add(new Energie("Chauffage", 50, FacteursEmission.FACTEUR_ELECTRICITE)));
    }

    @Test
    public void testTailleEntrepriseLimits() {
        Entreprise petite = new Entreprise("Petite");
        petite.addPoste(new Energie("Éclairage", 1, FacteursEmission.FACTEUR_ELECTRICITE));
        assertEquals("Petite entreprise", petite.tailleEntreprise());

        Entreprise moyenne = new Entreprise("Moyenne");
        moyenne.addPoste(new Energie("Électricité", 20000, FacteursEmission.FACTEUR_ELECTRICITE));
        assertEquals("Moyenne entreprise", moyenne.tailleEntreprise());

        Entreprise grande = new Entreprise("Grande");
        grande.addPoste(new Energie("Électricité", 200000, FacteursEmission.FACTEUR_ELECTRICITE));
        assertEquals("Grande entreprise", grande.tailleEntreprise());
    }

    @Test
    public void testAfficherOutputsExpectedContent() {
        Entreprise entreprise = new Entreprise("AffichageTest");
        entreprise.addPoste(new Energie("Électricité", 100, FacteursEmission.FACTEUR_ELECTRICITE));
        entreprise.addPoste(new Transport("Train", 200, "train"));

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));
        try {
            entreprise.afficher();
        } finally {
            System.setOut(originalOut);
        }

        String output = out.toString();
        assertTrue(output.contains("Entreprise: AffichageTest"));
        assertTrue(output.contains("Électricité"));
        assertTrue(output.contains("Train"));
        assertTrue(output.contains("Empreinte totale:"));
    }
}
