package com.projetia0;

import com.projetia0.model.Energie;
import com.projetia0.model.Entreprise;
import com.projetia0.model.PosteEmission;
import com.projetia0.model.Transport;
import com.projetia0.service.FacteursEmission;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testConstruireRapport() throws Exception {
        Entreprise entreprise = new Entreprise("RapportTest");
        entreprise.addPoste(new Energie("Électricité", 100, FacteursEmission.FACTEUR_ELECTRICITE));
        entreprise.addPoste(new Transport("Train", 200, "train"));

        Method method = App.class.getDeclaredMethod("construireRapport", Entreprise.class);
        method.setAccessible(true);
        String rapport = (String) method.invoke(null, entreprise);

        assertEquals("Entreprise : RapportTest\n" +
                "Taille : Petite entreprise\n\n" +
                "Postes d'émission :\n" +
                "- Électricité : " + (100 * FacteursEmission.FACTEUR_ELECTRICITE) + " kg CO2\n" +
                "- Train : " + (200 * FacteursEmission.getTransportFactor("train")) + " kg CO2\n",
                rapport);
    }
}
