package com.nelkinda.training.gameoflife;

import com.nelkinda.training.gameoflife.life2d.Point2D;
import org.junit.jupiter.api.Test;

import static com.nelkinda.training.gameoflife.life2d.Point2D.P;
import static com.nelkinda.training.gameoflife.Rules.standardRules;
import static java.util.Set.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SuppressWarnings({"PMD.JUnitTestContainsTooManyAsserts", "PMD.ShortVariable"})
class UniverseTest {

    @Test
    void equality() {
        final Universe<Point2D> u1 = new Universe<>(standardRules(of(), of()));
        final Universe<Point2D> u2 = new Universe<>(standardRules(of(), of()));
        assertEquals(u1, u2);
        assertEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    void inEquality() {
        final Universe<Point2D> u1 = new Universe<>(standardRules(of(), of(1)));
        final Universe<Point2D> u2 = new Universe<>(standardRules(of(1), of()));
        assertNotEquals(u1, u2);
        assertNotEquals(u1.hashCode(), u2.hashCode());
    }

    @Test
    void testToString() {
        assertEquals("Universe{R 23/3\n[P(0, 1)]}", new Universe<>(of(P(0, 1))).toString());
    }
}
