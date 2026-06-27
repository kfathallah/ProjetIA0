package com.projetia0.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteConnexionService {
    private final Path dbPath;

    public SqliteConnexionService(Path dbPath) {
        this.dbPath = dbPath;
    }

    public void initialiserSchema() throws SQLException {
        Path parent = dbPath.getParent();
        if (parent != null) {
            try {
                Files.createDirectories(parent);
            } catch (Exception e) {
                throw new SQLException("Impossible de créer le dossier de la base SQLite", e);
            }
        }

        try (Connection connection = ouvrirConnexion();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS empreintes (id INTEGER PRIMARY KEY AUTOINCREMENT, nom TEXT NOT NULL, valeur REAL NOT NULL)");
        }
    }

    public void enregistrerEmpreinte(String nom, double valeur) throws SQLException {
        try (Connection connection = ouvrirConnexion();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO empreintes (nom, valeur) VALUES (?, ?)")) {
            statement.setString(1, nom);
            statement.setDouble(2, valeur);
            statement.executeUpdate();
        }
    }

    public int compterEmpreintes() throws SQLException {
        try (Connection connection = ouvrirConnexion();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM empreintes")) {
            resultSet.next();
            return resultSet.getInt(1);
        }
    }

    private Connection ouvrirConnexion() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath.toAbsolutePath());
    }
}
