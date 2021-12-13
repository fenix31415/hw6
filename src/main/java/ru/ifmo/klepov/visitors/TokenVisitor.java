package ru.ifmo.klepov.visitors;

import ru.ifmo.klepov.tokens.Brace;
import ru.ifmo.klepov.tokens.NumberToken;
import ru.ifmo.klepov.tokens.Operation;

public interface TokenVisitor {
    void visit(NumberToken token);

    void visit(Brace token);

    void visit(Operation token);
}
