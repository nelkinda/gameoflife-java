package com.nelkinda.training.gameoflife;

import java.math.BigInteger;

class X extends Coordinate<X> {
    X(final BigInteger value) {
        super(value);
    }

    X(final int value) {
        super(value);
    }

    X add(final X other) {
        return new X(value.add(other.value));
    }
}
