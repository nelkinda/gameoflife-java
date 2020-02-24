package com.nelkinda.training.gameoflife;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.nelkinda.training.gameoflife.Parser.parseSimplifiedLife1_05;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeSteps {
    private Universe universe;

    @Given("the following universe:")
    public void defineUniverse(final String spec) {
        universe = parseSimplifiedLife1_05(spec);
    }

    @Then("the next generation MUST be:")
    public void assertNextGenerationEquals(final String spec) {
        universe = universe.next();
        assertEquals(parseSimplifiedLife1_05(spec), universe);
    }
}
