package com.nelkinda.training.gameoflife;

import java.util.Set;
import java.util.stream.Stream;

import static com.nelkinda.training.gameoflife.Rules.CONWAY_RULES;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.concat;

@SuppressWarnings({"java:S119","ClassTypeParameterName", "PMD.GenericsNaming"})
public record Universe<Cell extends Point<Cell>>(
        Rules rules,
        Set<Cell> life
) {
    @SafeVarargs
    Universe(final Rules rules, final Cell... life) {
        this(rules, Set.of(life));
    }

    Universe(final Set<Cell> life) {
        this(CONWAY_RULES, life);
    }

    Universe<Cell> next() {
        return new Universe<>(rules, cellsOfNextGeneration());
    }

    private Set<Cell> cellsOfNextGeneration() {
        return concat(survivingCells(), bornCells()).collect(toSet());
    }

    private Stream<Cell> survivingCells() {
        return life
                .stream()
                .filter(this::survives);
    }

    private Stream<Cell> deadNeighborsOfLivingCells() {
        return life
                .stream()
                .flatMap(this::deadNeighbors)
                .distinct();
    }

    private Stream<Cell> bornCells() {
        return deadNeighborsOfLivingCells()
                .filter(this::born);
    }

    private boolean survives(final Cell cell) {
        return rules.survives(countLiveNeighbors(cell));
    }

    private boolean born(final Cell cell) {
        return rules.born(countLiveNeighbors(cell));
    }

    private boolean isAlive(final Cell cell) {
        return life.contains(cell);
    }

    private boolean isDead(final Cell cell) {
        return !isAlive(cell);
    }

    private Stream<Cell> deadNeighbors(final Cell cell) {
        return cell.neighbors(this::isDead);
    }

    private Stream<Cell> liveNeighbors(final Cell cell) {
        return cell.neighbors(this::isAlive);
    }

    private int countLiveNeighbors(final Cell cell) {
        return (int) liveNeighbors(cell).count();
    }

    @Override
    public String toString() {
        return "Universe{" + rules + "\n" + life + '}';
    }
}
