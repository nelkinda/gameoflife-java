package com.nelkinda.training.gameoflife;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.Objects.hash;
import static java.util.Set.of;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.concat;

public class Universe {
    private final Rules rules;
    private final Set<Point> life;

    Universe(final Rules rules, final Point... life) {
        this(rules, of(life));
    }

    private Universe(final Rules rules, final Set<Point> life) {
        this.rules = rules;
        this.life = life;
    }

    Universe(final Set<Point> life) {
        this(Rules.ConwayRules, life);
    }

    Universe next() {
        return new Universe(rules, concat(survivingCells(), bornCells()).collect(toSet()));
    }

    private Stream<Point> survivingCells() {
        return life.stream().filter(this::survives);
    }

    private boolean survives(final Point cell) {
        return rules.survives(countLiveNeighbors(cell));
    }

    private Stream<Point> bornCells() {
        return life.stream().flatMap(this::deadNeighbors).distinct().filter(this::born);
    }

    private boolean born(final Point cell) {
        return rules.born(countLiveNeighbors(cell));
    }

    private int countLiveNeighbors(final Point cell) {
        return (int) liveNeighbors(cell).count();
    }

    private Stream<Point> deadNeighbors(final Point cell) {
        return cell.neighbors().filter(not(life::contains));
    }

    private Stream<Point> liveNeighbors(final Point cell) {
        return cell.neighbors().filter(life::contains);
    }

    @Override
    public boolean equals(final Object o) {
        return this == o || o != null && getClass() == o.getClass() && equals((Universe) o);
    }

    private boolean equals(final Universe universe) {
        return rules.equals(universe.rules) && life.equals(universe.life);
    }

    @Override
    public int hashCode() {
        return hash(rules, life);
    }

    @Override
    public String toString() {
        return "Universe{" + rules + "\n" + life + '}';
    }
}
