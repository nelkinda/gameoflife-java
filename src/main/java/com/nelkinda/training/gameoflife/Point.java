package com.nelkinda.training.gameoflife;

import java.math.BigInteger;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.Objects.hash;
import static java.util.Set.of;

public class Point {
    private static final Set<Point> neighborSet = of(P(-1, -1), P(-1, 0), P(-1, 1), P(0, -1), P(0, 1), P(1, -1), P(1, 0), P(1, 1));
    private final X x;
    private final Y y;

    private Point(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }

    static Point P(final BigInteger x, final BigInteger y) {
        return new Point(new X(x), new Y(y));
    }

    static Point P(final int x, final int y) {
        return new Point(new X(x), new Y(y));
    }

    @Override
    public boolean equals(final Object o) {
        return this == o || o != null && getClass() == o.getClass() && x.equals(((Point) o).x) && y.equals(((Point) o).y);
    }

    @Override
    public int hashCode() {
        return hash(x, y);
    }

    @Override
    public String toString() {
        return "P(" + x + ", " + y + ")";
    }

    private Point add(final Point p) {
        return new Point(x.add(p.x), y.add(p.y));
    }

    Stream<Point> neighbors() {
        return neighborSet.stream().map(this::add);
    }
}
