package com.nelkinda.training.gameoflife.life2d;

import org.junit.jupiter.api.Test;

import static com.nelkinda.training.gameoflife.life2d.Point2D.P;
import static java.util.Set.of;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"PMD.JUnitTestContainsTooManyAsserts", "PMD.ShortVariable"})
class Point2DTest {
    @Test
    void testToString() {
        assertEquals("P(0, 1)", P(0, 1).toString());
    }

    @Test
    void equalPoints() {
        final Point2D p1 = P(0, 0);
        final Point2D p2 = P(0, 0);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void notEqualPoints() {
        final Point2D p1 = P(0, 0);
        final Point2D p2 = P(0, 1);
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void plus() {
        assertEquals(P(3, 30), P(2,  20).plus(P(1, 10)));
    }

    @Test
    void rangeTo() {
        assertEquals(of(P(0, 0), P(0, 1), P(0, 2)), P(0, 0).rangeTo(P(0, 2)).collect(toSet()));
    }

    @Test
    void neighbors() {
        assertEquals(
                of(P(4, 49), P(4, 50), P(4, 51), P(5, 49), P(5, 51), P(6, 49), P(6, 50), P(6, 51)),
                P(5, 50).neighbors().collect(toSet())
        );
    }
}
