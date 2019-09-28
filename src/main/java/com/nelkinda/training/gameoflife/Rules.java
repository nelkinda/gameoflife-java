package com.nelkinda.training.gameoflife;


import java.util.Set;

import static java.util.Set.of;
import static java.util.stream.Collectors.joining;

public interface Rules {
    Rules ConwayRules = standardRules(of(2, 3), of(3));

    static Rules standardRules(final Set<Integer> survive, final Set<Integer> born) {
        return new Rules() {
            @Override
            public boolean survives(final int neighbors) {
                return survive.contains(neighbors);
            }

            @Override
            public boolean born(final int neighbors) {
                return born.contains(neighbors);
            }

            @Override
            public String toString() {
                return "R " + toString(survive) + "/" + toString(born);
            }

            private String toString(final Set<Integer> set) {
                return set.stream().sorted().map(Object::toString).collect(joining());
            }
        };
    }

    boolean survives(int neighbors);

    boolean born(int neighbors);
}
