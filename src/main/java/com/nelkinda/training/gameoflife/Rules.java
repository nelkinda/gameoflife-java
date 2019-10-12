package com.nelkinda.training.gameoflife;


import java.util.Set;

import static java.util.Set.of;
import static java.util.stream.Collectors.joining;

public interface Rules {
    Rules ConwayRules = standardRules(of(2, 3), of(3));

    static Rules standardRules(final Set<Integer> liveNeighborsForSurvival, final Set<Integer> liveNeighborsForBirth) {
        return new Rules() {
            @Override
            public boolean survives(final int liveNeighbors) {
                return liveNeighborsForSurvival.contains(liveNeighbors);
            }

            @Override
            public boolean born(final int liveNeighbors) {
                return liveNeighborsForBirth.contains(liveNeighbors);
            }

            @Override
            public String toString() {
                return "R " + toString(liveNeighborsForSurvival) + "/" + toString(liveNeighborsForBirth);
            }

            private String toString(final Set<Integer> set) {
                return set.stream().sorted().map(Object::toString).collect(joining());
            }
        };
    }

    boolean survives(int liveNeighbors);

    boolean born(int liveNeighbors);
}
