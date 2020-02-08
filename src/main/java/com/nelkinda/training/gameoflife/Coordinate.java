package com.nelkinda.training.gameoflife;

import lombok.EqualsAndHashCode;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;

@EqualsAndHashCode
final class Coordinate<T extends Coordinate.Dimension> {
    final BigInteger value;

    Coordinate(final BigInteger value) {
        this.value = value;
    }

    Coordinate(final int value) {
        this.value = valueOf(value);
    }

    Coordinate<T> add(final Coordinate<T> other) {
        return new Coordinate<>(value.add(other.value));
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public interface Dimension {
    }
}
