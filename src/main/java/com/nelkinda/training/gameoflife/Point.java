package com.nelkinda.training.gameoflife;

import java.math.BigInteger;
import java.util.Set;
import java.util.stream.Stream;

import static java.math.BigInteger.valueOf;
import static java.util.Objects.hash;
import static java.util.Set.of;

public class Point {
    private static final Set<Point> neighborSet = of(P(-1, -1), P(-1, 0), P(-1, 1), P(0, -1), P(0, 1), P(1, -1), P(1, 0), P(1, 1));
    private final BigInteger x;
    private final BigInteger y;

    private Point(final BigInteger x, final BigInteger y) {
        this.x = x;
        this.y = y;
    }

    private Point(final int x, final int y) {
        this(valueOf(x), valueOf(y));
    }

    static Point P(final BigInteger x, final BigInteger y) {
        return new Point(x, y);
    }

    static Point P(final int x, final int y) {
        return new Point(x, y);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Point point = (Point) o;
        return x.equals(point.x) && y.equals(point.y);
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
        return P(x.add(p.x), y.add(p.y));
    }

    Stream<Point> neighbors() {
        return neighborSet.stream().map(this::add);
    }
}
