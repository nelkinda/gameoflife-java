package com.nelkinda.training.gameoflife;

import java.math.BigInteger;

class X extends Coordinate<X> {
    private X(final BigInteger value) {
        super(value);
    }

    X(final int value) {
        super(value);
    }

    X add(final X other) {
        return new X(value.add(other.value));
    }
}
