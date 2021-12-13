package ru.ifmo.klepov.tokens;

import ru.ifmo.klepov.visitors.TokenVisitor;

public abstract class Brace implements Token {
    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
