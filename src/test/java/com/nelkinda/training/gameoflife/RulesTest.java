package com.nelkinda.training.gameoflife;

import org.junit.jupiter.api.Test;

import static com.nelkinda.training.gameoflife.Rules.ConwayRules;
import static org.junit.jupiter.api.Assertions.*;

class RulesTest {

    @Test
    void standardRules() {
        assertAll(
                () -> assertEquals("R 23/3", ConwayRules.toString()),
                () -> assertFalse(ConwayRules.survives(1)),
                () -> assertTrue(ConwayRules.survives(2)),
                () -> assertTrue(ConwayRules.survives(3)),
                () -> assertFalse(ConwayRules.survives(4)),
                () -> assertFalse(ConwayRules.born(2)),
                () -> assertTrue(ConwayRules.born(3)),
                () -> assertFalse(ConwayRules.born(4))
        );
    }
}
