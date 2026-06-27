package com.projetia0.service;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqliteConnexionServiceTest {

    @Test
    void testInitialiserSchemaEtEnregistrerEmpreinte() throws Exception {
        Path dbPath = Files.createTempFile("empreinte-test", ".db");
        Files.deleteIfExists(dbPath);

        SqliteConnexionService service = new SqliteConnexionService(dbPath);
        service.initialiserSchema();
        service.enregistrerEmpreinte("Test", 12.5);

        assertEquals(1, service.compterEmpreintes());
    }
}
