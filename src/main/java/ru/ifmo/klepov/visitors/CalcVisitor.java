package ru.ifmo.klepov.visitors;

import ru.ifmo.klepov.tokens.Brace;
import ru.ifmo.klepov.tokens.NumberToken;
import ru.ifmo.klepov.tokens.Operation;

import java.util.Stack;

public class CalcVisitor implements TokenVisitor {
    final Stack<Long> stack = new Stack<>();

    private void ensure(boolean b) {
        if (!b) {
            throw new VisitorException("Incorrect expression");
        }
    }

    @Override
    public void visit(final NumberToken token) {
        stack.push(token.getValue());
    }

    @Override
    public void visit(final Brace token) {
        assert false;
    }

    @Override
    public void visit(final Operation token) {
        ensure(stack.size() >= 2);

        final long x = stack.pop();
        stack.push(token.calculate(stack.pop(), x));
    }

    public long calculate() {
        ensure(stack.size() == 1);
        return stack.pop();
    }
}
