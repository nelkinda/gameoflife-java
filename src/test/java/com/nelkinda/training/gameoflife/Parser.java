package com.nelkinda.training.gameoflife;

import java.util.HashSet;
import java.util.Set;

import static com.nelkinda.training.gameoflife.Point.P;
import static java.util.Collections.unmodifiableSet;

enum Parser {
    ;

    @SuppressWarnings({
            "checkstyle:ParameterName",
            "PMD.FormalParameterNamingConventions",
            "PMD.MethodNamingConventions",
            "PMD.MissingBreakInSwitch"
    })
    static Universe parseSimplifiedLife1_05(final String life1_05) {
        final Set<Point> cells = new HashSet<>();
        int line = 0;
        int column = 0;
        for (final char c : life1_05.toCharArray()) {
            switch (c) {
            case '\n':
                line++;
                column = 0;
                break;
            case '*':
                cells.add(P(column, line));
                //fallthrough
            case '.':
                column++;
                break;
            default:
                final var msg = "Unexpected character '" + c + "' at line " + line + ", column " + column;
                throw new IllegalArgumentException(msg);
            }
        }
        return new Universe(unmodifiableSet(cells));
    }
}
