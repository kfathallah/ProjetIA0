package com.projetia0.model;

import com.projetia0.service.FacteursEmission;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransportTest {

    @Test
    public void testTransportCalculEmission() {
        Transport transport = new Transport("Transport par train", 200, "train");

        assertEquals("Transport par train", transport.getDescription());
        assertEquals(200, transport.getDistanceKm(), 1e-6);
        assertEquals("train", transport.getMode());
        assertEquals(200 * FacteursEmission.getTransportFactor("train"), transport.getEmissionKgCO2(), 1e-6);
    }
}
