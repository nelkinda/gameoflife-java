package com.nelkinda.training.gameoflife;

import org.junit.jupiter.api.Test;

import static com.nelkinda.training.gameoflife.Point.P;
import static com.nelkinda.training.gameoflife.Rules.standardRules;
import static java.util.Set.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UniverseTest {

    @Test
    void equality() {
        final Universe u1 = new Universe(standardRules(of(), of()));
        final Universe u2 = new Universe(standardRules(of(), of()));
        assertEquals(u1, u2);
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    void inEquality() {
        final Universe u1 = new Universe(standardRules(of(), of(1)));
        final Universe u2 = new Universe(standardRules(of(1), of()));
        assertNotEquals(u1, u2);
        assertNotEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Universe{R 23/3\n[P(0, 1)]}", new Universe(of(P(0, 1))).toString());
    }
}
