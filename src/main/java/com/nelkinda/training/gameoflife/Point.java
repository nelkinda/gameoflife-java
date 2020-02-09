package com.nelkinda.training.gameoflife;

import com.nelkinda.training.gameoflife.Point.Coordinate.Dimension.X;
import com.nelkinda.training.gameoflife.Point.Coordinate.Dimension.Y;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.math.BigInteger.valueOf;
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

    @EqualsAndHashCode
    static final class Coordinate<T extends Coordinate.Dimension> {
        final BigInteger value;

        Coordinate(final BigInteger value) {
            this.value = value;
        }

        Coordinate(final int value) {
            this.value = valueOf(value);
        }

        Coordinate<T> add(final Coordinate<T> other) {
            return new Coordinate<>(value.add(other.value));
        }

        @Override
        public String toString() {
            return value.toString();
        }

        interface Dimension {
            interface X extends Dimension {
            }

            interface Y extends Dimension {
            }
        }
    }
}
