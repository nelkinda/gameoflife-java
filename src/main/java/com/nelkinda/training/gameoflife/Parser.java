package com.nelkinda.training.gameoflife;

import java.util.HashSet;
import java.util.Set;

import static com.nelkinda.training.gameoflife.Point.P;
import static java.util.Collections.unmodifiableSet;

public enum Parser {
    ;

    public static Universe parse(final String s) {
        final Set<Point> points = new HashSet<>();
        int line = 0;
        int column = 0;
        for (final char c : s.toCharArray()) {
            switch (c) {
            case '\n':
                line++;
                column = 0;
                break;
            case 'x':
                points.add(P(column, line));
            case '.':
                column++;
                break;
            default:
                throw new IllegalArgumentException("Unexpected character '" + c + "' at line " + line + ", column " + column);
            }
        }
        return new Universe(unmodifiableSet(points));
    }
}
