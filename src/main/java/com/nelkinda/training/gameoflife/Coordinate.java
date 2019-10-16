package com.nelkinda.training.gameoflife;

import java.math.BigInteger;

import static java.math.BigInteger.valueOf;
import static java.util.Objects.hash;

public abstract class Coordinate<T extends Coordinate<T>> {
    final BigInteger value;

    Coordinate(final BigInteger value) {
        this.value = value;
    }

    Coordinate(final int value) {
        this.value = valueOf(value);
    }

    abstract T add(final T t);

    @Override
    public boolean equals(final Object o) {
        return this == o || o != null && getClass() == o.getClass() && value.equals(((Coordinate<?>) o).value);
    }

    @Override
    public int hashCode() {
        return hash(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
