package com.nelkinda.training.gameoflife;

import org.junit.jupiter.api.Test;

import static com.nelkinda.training.gameoflife.Parser.parseSimplifiedLife1_05;
import static com.nelkinda.training.gameoflife.Point.P;
import static java.util.Set.of;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    private static void parses(final String spec, final Point... cells) {
        assertEquals(new Universe(of(cells)), parseSimplifiedLife1_05(spec));
    }

    @Test
    void testParses() {
        assertAll(
                () -> parses(""),
                () -> parses("*", P(0, 0)),
                () -> parses("**", P(0, 0), P(1, 0)),
                () -> parses("*\n*", P(0, 0), P(0, 1)),
                () -> parses("*.*", P(0, 0), P(2, 0))
        );
    }

    @SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
    @Test
    void testInvalid() {
        final var exception = assertThrows(IllegalArgumentException.class, () -> parses("o"));
        assertEquals("Unexpected character 'o' at line 1, column 1", exception.getMessage());
    }
}
