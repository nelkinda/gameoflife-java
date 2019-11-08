package com.nelkinda.training.gameoflife;

import lombok.EqualsAndHashCode;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;

@EqualsAndHashCode
abstract class Coordinate<T extends Coordinate<T>> {
    final BigInteger value;

    Coordinate(final BigInteger value) {
        this.value = value;
    }

    Coordinate(final int value) {
        this.value = valueOf(value);
    }

    abstract T add(final T t);

    @Override
    public String toString() {
        return value.toString();
    }
}
