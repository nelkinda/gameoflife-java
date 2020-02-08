package com.nelkinda.training.gameoflife;

import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Set.of;

@EqualsAndHashCode
class Point {
    private static final Set<Point> neighborSet = of(
            //@formatter:off
            P(-1,  1), P( 0,  1), P( 1,  1),
            P(-1,  0),            P( 1,  0),
            P(-1, -1), P( 0, -1), P( 1, -1)
            //@formatter:on
    );
    private final Coordinate<X> x;
    private final Coordinate<Y> y;

    private Point(final Coordinate<X> x, final Coordinate<Y> y) {
        this.x = x;
        this.y = y;
    }

    @SuppressWarnings("squid:S00100") // Using the unusual name P for creating a DSL.
    static Point P(final int x, final int y) {
        return new Point(new Coordinate<>(x), new Coordinate<>(y));
    }

    private Point add(final Point p) {
        return new Point(x.add(p.x), y.add(p.y));
    }

    Stream<Point> neighbors() {
        return neighborSet.stream().map(this::add);
    }

    Stream<Point> neighbors(final Predicate<Point> predicate) {
        return neighbors().filter(predicate);
    }

    @Override
    public String toString() {
        return "P(" + x + ", " + y + ")";
    }
}
