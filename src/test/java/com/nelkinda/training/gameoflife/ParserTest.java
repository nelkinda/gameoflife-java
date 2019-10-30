package com.nelkinda.training.gameoflife;

import org.junit.jupiter.api.Test;

import static com.nelkinda.training.gameoflife.Parser.parse;
import static com.nelkinda.training.gameoflife.Point.P;
import static java.util.Set.of;
import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    private static void parses(final String spec, final Point... cells) {
        assertEquals(new Universe(of(cells)), parse(spec));
    }

    @Test
    void empty() {
        assertAll(
                () -> parses(""),
                () -> parses("x", P(0, 0)),
                () -> parses("xx", P(0, 0), P(1, 0)),
                () -> parses("x\nx", P(0, 0), P(0, 1)),
                () -> parses("x.x", P(0, 0), P(2, 0))
        );
        assertThrows(IllegalArgumentException.class, () -> parses("o"));
    }
}
