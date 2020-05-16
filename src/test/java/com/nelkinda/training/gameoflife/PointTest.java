package com.nelkinda.training.gameoflife;

import org.junit.jupiter.api.Test;

import static com.nelkinda.training.gameoflife.Point.P;
import static java.util.Set.of;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"PMD.JUnitTestContainsTooManyAsserts", "PMD.ShortVariable"})
class PointTest {
    @Test
    void testToString() {
        assertEquals("P(0, 1)", P(0, 1).toString());
    }

    @Test
    void equalPoints() {
        final Point p1 = P(0, 0);
        final Point p2 = P(0, 0);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void notEqualPoints() {
        final Point p1 = P(0, 0);
        final Point p2 = P(0, 1);
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void neighbors() {
        assertEquals(
                of(P(4, 4), P(4, 5), P(4, 6), P(5, 4), P(5, 6), P(6, 4), P(6, 5), P(6, 6)),
                P(5, 5).neighbors().collect(toSet())
        );
    }
}
