package com.nelkinda.training.gameoflife;

import java.math.BigInteger;

class Y extends Coordinate<Y> {
    private Y(final BigInteger value) {
        super(value);
    }

    Y(final int value) {
        super(value);
    }

    Y add(final Y other) {
        return new Y(value.add(other.value));
    }
}
