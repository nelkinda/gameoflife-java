package com.nelkinda.training.gameoflife;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.nelkinda.training.gameoflife.Parser.parse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeSteps {
    private Universe universe;

    @Given("the following universe:")
    public void defineUniverse(final String spec) {
        universe = parse(spec);
    }

    @When("creating the next iteration")
    public void createNext() {
        universe = universe.next();
    }

    @Then("the universe MUST be equal to:")
    public void mustBeEqual(final String spec) {
        assertEquals(parse(spec), universe);
    }
}
