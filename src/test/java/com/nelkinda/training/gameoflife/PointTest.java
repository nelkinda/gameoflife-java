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
    void plus() {
        assertEquals(P(3, 30), P(2,  20).plus.apply(P(1, 10)));
    }

    @Test
    void neighbors() {
        assertEquals(
                of(P(4, 49), P(4, 50), P(4, 51), P(5, 49), P(5, 51), P(6, 49), P(6, 50), P(6, 51)),
                P(5, 50).neighbors.get().collect(toSet())
        );
    }
}
