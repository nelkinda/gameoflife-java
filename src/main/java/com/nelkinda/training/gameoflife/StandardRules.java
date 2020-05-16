package com.nelkinda.training.gameoflife;

import lombok.EqualsAndHashCode;

import java.util.Set;

import static java.util.stream.Collectors.joining;

@EqualsAndHashCode
class StandardRules implements Rules {
    private final Set<Integer> liveNeighborsForSurvival;
    private final Set<Integer> liveNeighborsForBirth;

    StandardRules(final Set<Integer> liveNeighborsForSurvival, final Set<Integer> liveNeighborsForBirth) {
        this.liveNeighborsForSurvival = liveNeighborsForSurvival;
        this.liveNeighborsForBirth = liveNeighborsForBirth;
    }

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
}
