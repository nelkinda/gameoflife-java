package com.nelkinda.training.gameoflife;


import java.util.Set;

import static java.util.Set.of;

@SuppressWarnings("squid:S1214") // Rules is the best place for the ConwayRules constant.
public interface Rules {
    Rules CONWAY_RULES = standardRules(of(2, 3), of(3));

    static Rules standardRules(final Set<Integer> liveNeighborsForSurvival, final Set<Integer> liveNeighborsForBirth) {
        return new StandardRules(liveNeighborsForSurvival, liveNeighborsForBirth);
    }

    boolean survives(int liveNeighbors);

    boolean born(int liveNeighbors);
}

