package com.nelkinda.training.gameoflife;

import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.stream.Stream;

import static com.nelkinda.training.gameoflife.Rules.ConwayRules;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.concat;

@EqualsAndHashCode
public class Universe {
    private final Rules rules;
    private final Set<Point> life;

    Universe(final Rules rules, final Point... life) {
        this(rules, Set.of(life));
    }

    private Universe(final Rules rules, final Set<Point> life) {
        this.rules = rules;
        this.life = life;
    }

    Universe(final Set<Point> life) {
        this(ConwayRules, life);
    }

    Universe next() {
        return new Universe(
                rules,
                concat(
                        survivingCells(),
                        bornCells()
                ).collect(toSet())
        );
    }

    private Stream<Point> survivingCells() {
        return life
                .stream()
                .filter(this::survives);
    }

    private boolean survives(final Point cell) {
        return rules.survives(countLiveNeighbors(cell));
    }

    private Stream<Point> bornCells() {
        return life
                .stream()
                .flatMap(this::deadNeighbors)
                .distinct()
                .filter(this::born);
    }

    private boolean isAlive(final Point cell) {
        return life.contains(cell);
    }

    private boolean born(final Point cell) {
        return rules.born(countLiveNeighbors(cell));
    }

    private int countLiveNeighbors(final Point cell) {
        return (int) liveNeighbors(cell).count();
    }

    private Stream<Point> deadNeighbors(final Point cell) {
        return cell.neighbors(not(this::isAlive));
    }

    private Stream<Point> liveNeighbors(final Point cell) {
        return cell.neighbors(this::isAlive);
    }

    @Override
    public String toString() {
        return "Universe{" + rules + "\n" + life + '}';
    }
}
