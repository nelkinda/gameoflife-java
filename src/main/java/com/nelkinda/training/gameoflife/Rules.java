package com.nelkinda.training.gameoflife;


import java.util.Set;

import static java.util.Objects.hash;
import static java.util.Set.of;
import static java.util.stream.Collectors.joining;

public interface Rules {
    Rules ConwayRules = standardRules(of(2, 3), of(3));

    static Rules standardRules(final Set<Integer> liveNeighborsForSurvival, final Set<Integer> liveNeighborsForBirth) {
        return new StandardRules(liveNeighborsForSurvival, liveNeighborsForBirth);
    }

    boolean survives(int liveNeighbors);

    boolean born(int liveNeighbors);

}

class StandardRules implements Rules {
    private final Set<Integer> liveNeighborsForSurvival;
    private final Set<Integer> liveNeighborsForBirth;

    StandardRules(Set<Integer> liveNeighborsForSurvival, Set<Integer> liveNeighborsForBirth) {
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
    public boolean equals(final Object o) {
        return this == o || o != null && getClass() == o.getClass() && equals((StandardRules) o);
    }

    private boolean equals(final StandardRules standardRules) {
        return liveNeighborsForSurvival.equals(standardRules.liveNeighborsForSurvival) &&
                liveNeighborsForBirth.equals(standardRules.liveNeighborsForBirth);
    }

    @Override
    public int hashCode() {
        return hash(liveNeighborsForSurvival, liveNeighborsForBirth);
    }

    @Override
    public String toString() {
        return "R " + toString(liveNeighborsForSurvival) + "/" + toString(liveNeighborsForBirth);
    }

    private String toString(final Set<Integer> set) {
        return set.stream().sorted().map(Object::toString).collect(joining());
    }
}
