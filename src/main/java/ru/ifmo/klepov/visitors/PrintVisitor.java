package ru.ifmo.klepov.visitors;

import ru.ifmo.klepov.tokens.Brace;
import ru.ifmo.klepov.tokens.NumberToken;
import ru.ifmo.klepov.tokens.Operation;
import ru.ifmo.klepov.tokens.Token;

public class PrintVisitor implements TokenVisitor {
    private static void justPrintName(final Token token) {
        System.out.print(token.getName() + " ");
    }

    @Override
    public void visit(final NumberToken token) {
        justPrintName(token);
    }

    @Override
    public void visit(final Brace token) {
        justPrintName(token);
    }

    @Override
    public void visit(final Operation token) {
        justPrintName(token);
    }
}
