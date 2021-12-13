package ru.ifmo.klepov.tokens;

import ru.ifmo.klepov.visitors.TokenVisitor;

public abstract class Operation implements Token {
    abstract public long calculate(final long a, final long b);

    abstract public int priority();

    @Override
    public void accept(final TokenVisitor visitor) {
        visitor.visit(this);
    }
}
