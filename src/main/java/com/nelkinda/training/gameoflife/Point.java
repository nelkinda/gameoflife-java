package com.nelkinda.training.gameoflife;

import com.nelkinda.training.gameoflife.Point.Coordinate.Dimension.X;
import com.nelkinda.training.gameoflife.Point.Coordinate.Dimension.Y;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.math.BigInteger;
import java.util.Set;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.math.BigInteger.valueOf;
import static java.util.Set.of;

@EqualsAndHashCode(of = {"x", "y"})
@SuppressWarnings({"checkstyle:MemberName", "PMD.ShortVariable"})
class Point {
    @SuppressWarnings({"checkstyle:ParenPad", "CommentsIndentation"})
    private static final Set<Point> NEIGHBOR_SET = of(
            //@formatter:off
            P(-1,  1), P( 0,  1), P( 1,  1),
            P(-1,  0),            P( 1,  0),
            P(-1, -1), P( 0, -1), P( 1, -1)
            //@formatter:on
    );
    @Getter
    private final Coordinate<X> x;

    @Getter
    private final Coordinate<Y> y;

    UnaryOperator<Point> plus = p -> new Point(getX().plus.apply(p.x), getY().plus.apply(p.y));
    Supplier<Stream<Point>> neighbors = () -> NEIGHBOR_SET.stream().map(plus);

    private Point(final Coordinate<X> x, final Coordinate<Y> y) {
        this.x = x;
        this.y = y;
    }

    // Using the unusual name P for creating a DSL.
    @SuppressWarnings({"squid:S00100", "checkstyle:MethodName", "PMD.ShortMethodName", "PMD.MethodNamingConventions"})
    static Point P(final int x, final int y) {
        return new Point(new Coordinate<>(x), new Coordinate<>(y));
    }

    @Override
    public String toString() {
        return "P(" + x + ", " + y + ")";
    }

    @EqualsAndHashCode(of = "value")
    static final class Coordinate<T extends Coordinate.Dimension> {
        @Getter
        final BigInteger value;

        final UnaryOperator<Coordinate<T>> plus = other -> new Coordinate<>(getValue().add(other.value));

        Coordinate(final BigInteger value) {
            this.value = value;
        }

        Coordinate(final int value) {
            this.value = valueOf(value);
        }

        @Override
        public String toString() {
            return value.toString();
        }

        @SuppressWarnings("PMD.ShortClassName")
        interface Dimension {
            interface X extends Dimension {
            }

            interface Y extends Dimension {
            }
        }
    }
}
