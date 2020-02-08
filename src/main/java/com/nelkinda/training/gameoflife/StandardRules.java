package com.nelkinda.training.gameoflife;

import java.util.Set;

import static java.util.stream.Collectors.joining;

record StandardRules(Set<Integer> liveNeighborsForSurvival, Set<Integer> liveNeighborsForBirth) implements Rules {
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
