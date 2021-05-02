package com.nelkinda.training.gameoflife.life2d;

import com.nelkinda.training.gameoflife.Point;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings({"checkstyle:MemberName", "PMD.ShortVariable"})
public record Point2D(
        int x,
        int y
) implements Point<Point2D> {
    @SuppressWarnings({"checkstyle:ParenPad", "CommentsIndentation"})
    private static final Set<Point2D> NEIGHBORS_OF_ORIGIN =
            P(-1, -1).rangeTo(P(1, 1)).filter(it -> !it.equals(P(0, 0))).collect(Collectors.toSet());

    // Using the unusual name P for creating a DSL.
    @SuppressWarnings({"squid:S00100", "checkstyle:MethodName", "PMD.ShortMethodName", "PMD.MethodNamingConventions"})
    public static Point2D P(final int x, final int y) {
        return new Point2D(x, y);
    }

    @Override
    public Point2D plus(final Point2D p) {
        return new Point2D(x + p.x, y + p.y);
    }

    @Override
    public Stream<Point2D> rangeTo(final Point2D p) {
        return IntStream.range(this.x, p.x + 1).boxed().flatMap(
                nx -> IntStream.range(this.y, p.y + 1).mapToObj(
                        ny -> P(nx, ny)
                )
        );
    }

    @Override
    public Stream<Point2D> neighbors() {
        return NEIGHBORS_OF_ORIGIN.stream().map(this::plus);
    }

    @Override
    public String toString() {
        return "P(" + x + ", " + y + ")";
    }
}
