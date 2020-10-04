package com.nelkinda.training.gameoflife.life3d;

import com.nelkinda.training.gameoflife.Point;
import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@EqualsAndHashCode
@SuppressWarnings({"checkstyle:MemberName", "PMD.ShortVariable"})
public class Point3D implements Point<Point3D> {
    @SuppressWarnings({"checkstyle:ParenPad", "CommentsIndentation"})
    private static final Set<Point3D> NEIGHBORS_OF_ORIGIN =
            P(-1, -1, -1).rangeTo(P(1, 1, 1)).filter(it -> !it.equals(P(0, 0, 0))).collect(Collectors.toSet());

    private final int x;
    private final int y;
    private final int z;

    Point3D(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Using the unusual name P for creating a DSL.
    @SuppressWarnings({"squid:S00100", "checkstyle:MethodName", "PMD.ShortMethodName", "PMD.MethodNamingConventions"})
    public static Point3D P(final int x, final int y, final int z) {
        return new Point3D(x, y, z);
    }

    @Override
    public Point3D plus(final Point3D p) {
        return new Point3D(x + p.x, y + p.y, z + p.z);
    }

    @Override
    public Stream<Point3D> rangeTo(final Point3D p) {
        return IntStream.range(this.x, p.x + 1).boxed().flatMap(
                nx -> IntStream.range(this.y, p.y + 1).boxed().flatMap(
                        ny -> IntStream.range(this.z, p.z + 1).mapToObj(
                                nz -> P(nx, ny, nz)
                        )
                )
        );
    }

    @Override
    public Stream<Point3D> neighbors() {
        return NEIGHBORS_OF_ORIGIN.stream().map(this::plus);
    }

    @Override
    public String toString() {
        return "P(" + x + ", " + y + ", " + z + ")";
    }
}
