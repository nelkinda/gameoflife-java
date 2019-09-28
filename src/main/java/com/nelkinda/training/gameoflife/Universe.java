package com.nelkinda.training.gameoflife;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.Objects.hash;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.concat;

public class Universe {
    private final Rules rules;
    private final Set<Point> life;

    private Universe(final Rules rules, final Set<Point> life) {
        this.rules = rules;
        this.life = life;
    }

    Universe(final Set<Point> life) {
        this(Rules.ConwayRules, life);
    }

    Universe next() {
        return new Universe(rules, concat(cellSurvival(), cellBirth()).collect(toSet()));
    }

    private Stream<Point> cellSurvival() {
        return life.stream().filter(this::survives);
    }

    private Stream<Point> cellBirth() {
        return life.stream().flatMap(this::getDeadNeighbors).distinct().filter(this::born);
    }

    private boolean survives(final Point cell) {
        return rules.survives(countLiveNeighbors(cell));
    }

    private int countLiveNeighbors(final Point cell) {
        return (int) cell.neighbors().filter(life::contains).count();
    }

    private Stream<Point> getDeadNeighbors(final Point point) {
        return point.neighbors().filter(not(life::contains));
    }

    private boolean born(final Point point) {
        return rules.born(countLiveNeighbors(point));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Universe universe = (Universe) o;
        return life.equals(universe.life);
    }

    @Override
    public int hashCode() {
        return hash(life);
    }

    @Override
    public String toString() {
        return "Universe{" + rules + "\n" + life + '}';
    }
}
