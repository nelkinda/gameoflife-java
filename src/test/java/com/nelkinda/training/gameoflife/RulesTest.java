package com.nelkinda.training.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.nelkinda.training.gameoflife.Rules.ConwayRules;
import static java.util.Set.of;
import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RulesTest {

    private void assertSurvival(final Rules rules, final Set<Integer> liveNeighbors) {
        assertAll(range(0, 8).mapToObj(neighbors ->
                () -> assertEquals(liveNeighbors.contains(neighbors), rules.survives(neighbors))));
    }

    private void assertBirth(final Rules rules, final Set<Integer> liveNeighbors) {
        assertAll(range(0, 8).mapToObj(neighbors ->
                () -> assertEquals(liveNeighbors.contains(neighbors), rules.born(neighbors))));
    }

    @Test
    void standardRules() {
        assertAll(
                () -> assertEquals("R 23/3", ConwayRules.toString()),
                () -> assertSurvival(ConwayRules, of(2, 3)),
                () -> assertBirth(ConwayRules, of(3))
        );
    }
}
