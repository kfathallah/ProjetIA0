package com.projetia0;

import com.projetia0.model.Achat;
import com.projetia0.model.Energie;
import com.projetia0.model.Entreprise;
import com.projetia0.model.PosteEmission;
import com.projetia0.model.Transport;
import com.projetia0.service.FacteursEmission;
import com.projetia0.service.SqliteConnexionService;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            Path dbPath = Path.of("data", "empreinte.db");
            SqliteConnexionService sqliteService = new SqliteConnexionService(dbPath);
            sqliteService.initialiserSchema();
            sqliteService.enregistrerEmpreinte("Demo", 42.0);
        } catch (Exception e) {
            System.err.println("Connexion SQLite impossible : " + e.getMessage());
        }

        SwingUtilities.invokeLater(App::lancerInterface);
    }

    private static void lancerInterface() {
        Entreprise entreprise = new Entreprise("Mon entreprise");
        entreprise.addPoste(new Energie("Électricité", 1200, FacteursEmission.FACTEUR_ELECTRICITE));
        entreprise.addPoste(new Transport("Train", 300, "train"));
        entreprise.addPoste(new Achat("Achats", 2500, FacteursEmission.FACTEUR_ACHATS));

        JFrame frame = new JFrame("Calculateur d'empreinte carbone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(620, 420);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        JLabel titleLabel = new JLabel("Empreinte carbone de l'entreprise", SwingConstants.CENTER);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
        detailsArea.setText(construireRapport(entreprise));
        panel.add(new JScrollPane(detailsArea), BorderLayout.CENTER);

        JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        DecimalFormat df = new DecimalFormat("0.##");
        JLabel resultLabel = new JLabel("Empreinte totale : " + df.format(entreprise.calculerEmpreinte()) + " kg CO2");
        resultLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        footer.add(resultLabel);
        panel.add(footer, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private static String construireRapport(Entreprise entreprise) {
        List<PosteEmission> postes = entreprise.getPostes();
        StringBuilder builder = new StringBuilder();
        builder.append("Entreprise : ").append(entreprise.getNom()).append("\n");
        builder.append("Taille : ").append(entreprise.tailleEntreprise()).append("\n\n");
        builder.append("Postes d'émission :\n");
        for (PosteEmission poste : postes) {
            builder.append("- ").append(poste.getDescription())
                    .append(" : ").append(poste.getEmissionKgCO2())
                    .append(" kg CO2\n");
        }
        return builder.toString();
    }
}
