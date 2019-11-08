package com.nelkinda.training.gameoflife;

import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.Set.of;

@EqualsAndHashCode
class Point {
    private static final Set<Point> neighborSet = of(P(-1, -1), P(-1, 0), P(-1, 1), P(0, -1), P(0, 1), P(1, -1), P(1, 0), P(1, 1));
    private final X x;
    private final Y y;

    private Point(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }

    static Point P(final int x, final int y) {
        return new Point(new X(x), new Y(y));
    }

    private Point add(final Point p) {
        return new Point(x.add(p.x), y.add(p.y));
    }

    Stream<Point> neighbors() {
        return neighborSet.stream().map(this::add);
    }

    @Override
    public String toString() {
        return "P(" + x + ", " + y + ")";
    }
}
