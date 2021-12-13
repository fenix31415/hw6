package ru.ifmo.klepov.tokens;

import ru.ifmo.klepov.visitors.TokenVisitor;

public interface Token {
    String getName();

    void accept(TokenVisitor visitor);
}
