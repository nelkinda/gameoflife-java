package com.nelkinda.training.gameoflife.life3d;

import org.junit.jupiter.api.Test;

import static com.nelkinda.training.gameoflife.life3d.Point3D.P;
import static java.util.Set.of;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"PMD.JUnitTestContainsTooManyAsserts", "PMD.ShortVariable"})
class Point3DTest {
    @Test
    void testToString() {
        assertEquals("P(0, 1, 2)", P(0, 1, 2).toString());
    }

    @Test
    void equalPoints() {
        final Point3D p1 = P(0, 0, 0);
        final Point3D p2 = P(0, 0, 0);
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void notEqualPoints() {
        final Point3D p1 = P(0, 0, 0);
        final Point3D p2 = P(0, 1, 2);
        assertNotEquals(p1, p2);
        assertNotEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void plus() {
        assertEquals(P(3, 30, 300), P(2,  20, 200).plus(P(1, 10, 100)));
    }

    @SuppressWarnings("LineLength")
    @Test
    void neighbors() {
        assertEquals(
                of(
                        P(4, 49, 499), P(4, 50, 499), P(4, 51, 499), P(5, 49, 499), P(5, 50, 499), P(5, 51, 499), P(6, 49, 499), P(6, 50, 499), P(6, 51, 499),
                        P(4, 49, 500), P(4, 50, 500), P(4, 51, 500), P(5, 49, 500),                P(5, 51, 500), P(6, 49, 500), P(6, 50, 500), P(6, 51, 500),
                        P(4, 49, 501), P(4, 50, 501), P(4, 51, 501), P(5, 49, 501), P(5, 50, 501), P(5, 51, 501), P(6, 49, 501), P(6, 50, 501), P(6, 51, 501)
                ),
                P(5, 50, 500).neighbors().collect(toSet())
        );
    }
}
