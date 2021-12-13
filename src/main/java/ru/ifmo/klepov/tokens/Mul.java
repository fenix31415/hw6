package ru.ifmo.klepov.tokens;

public class Mul extends Operation {
    @Override
    public long calculate(final long a, final long b) {
        return a * b;
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public String getName() {
        return "MUL";
    }
}
