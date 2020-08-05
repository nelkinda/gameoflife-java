package com.nelkinda.training.gameoflife;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import static com.nelkinda.training.gameoflife.Rules.CONWAY_RULES;
import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Stream.concat;

@EqualsAndHashCode(of = {"rules", "life"})
public class Universe {
    @Getter
    private final Rules rules;

    @Getter
    private final Set<Point> life;

    private final Predicate<Point> isAlive = cell -> getLife().contains(cell);
    private final Function<Point, Stream<Point>> liveNeighbors = cell -> cell.neighbors.get().filter(isAlive);
    private final ToIntFunction<Point> countLiveNeighbors = cell -> (int) liveNeighbors.apply(cell).count();
    private final Predicate<Point> born = cell -> getRules().born(countLiveNeighbors.applyAsInt(cell));
    private final Predicate<Point> survives = cell -> getRules().survives(countLiveNeighbors.applyAsInt(cell));
    private final Function<Point, Stream<Point>> deadNeighbors = cell -> cell.neighbors.get().filter(not(isAlive));

    private final Supplier<Stream<Point>> survivingCells = () -> getLife().stream().filter(survives);
    private final Supplier<Stream<Point>> deadNeighborsOfLivingCells =
            () -> getLife().stream().flatMap(deadNeighbors).distinct();
    private final Supplier<Stream<Point>> bornCells = () -> deadNeighborsOfLivingCells.get().filter(born);

    final Supplier<Universe> next =
            () -> new Universe(getRules(), concat(survivingCells.get(), bornCells.get()).collect(toSet()));


    Universe(final Rules rules, final Point... life) {
        this(rules, Set.of(life));
    }

    private Universe(final Rules rules, final Set<Point> life) {
        this.rules = rules;
        this.life = life;
    }

    Universe(final Set<Point> life) {
        this(CONWAY_RULES, life);
    }

    @Override
    public String toString() {
        return "Universe{" + rules + "\n" + life + '}';
    }
}
