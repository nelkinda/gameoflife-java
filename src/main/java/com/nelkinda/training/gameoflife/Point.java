package com.nelkinda.training.gameoflife;

import java.util.function.Predicate;
import java.util.stream.Stream;

@SuppressWarnings("PMD.ShortVariable")
public interface Point<P extends Point<P>> {
    P plus(P p);

    Stream<P> rangeTo(P p);

    Stream<P> neighbors();

    default Stream<P> neighbors(final Predicate<P> predicate) {
        return neighbors().filter(predicate);
    }
}
