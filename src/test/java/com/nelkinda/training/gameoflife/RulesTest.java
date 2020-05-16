package com.nelkinda.training.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.nelkinda.training.gameoflife.Rules.CONWAY_RULES;
import static com.nelkinda.training.gameoflife.Rules.standardRules;
import static java.util.Set.of;
import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
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
    void testConwayRules() {
        assertAll(
                () -> assertEquals("R 23/3", CONWAY_RULES.toString()),
                () -> assertSurvival(CONWAY_RULES, of(2, 3)),
                () -> assertBirth(CONWAY_RULES, of(3))
        );
    }

    @Test
    void equality() {
        final Rules rules1 = standardRules(of(), of());
        final Rules rules2 = standardRules(of(), of());
        assertEquals(rules1, rules2);
        assertEquals(rules1.hashCode(), rules2.hashCode());
    }

    @Test
    void inEquality() {
        final Rules rules1 = standardRules(of(), of(1));
        final Rules rules2 = standardRules(of(1), of());
        assertNotEquals(rules1, rules2);
        assertNotEquals(rules1.hashCode(), rules2.hashCode());
    }
}
