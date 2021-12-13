package ru.ifmo.klepov.tokens;

public class Minus extends Operation {
    @Override
    public long calculate(final long a, final long b) {
        return a - b;
    }

    @Override
    public int priority() {
        return 1;
    }

    @Override
    public String getName() {
        return "MINUS";
    }
}
