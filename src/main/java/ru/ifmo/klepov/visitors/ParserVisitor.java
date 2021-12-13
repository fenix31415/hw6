package ru.ifmo.klepov.visitors;

import ru.ifmo.klepov.tokens.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParserVisitor implements TokenVisitor {
    final List<Token> result = new ArrayList<>();
    final Stack<Token> stack = new Stack<>();

    @Override
    public void visit(final NumberToken token) {
        result.add(token);
    }

    @Override
    public void visit(final Brace token) {
        if (token instanceof LeftBrace) {
            stack.push(token);
        } else {
            assert token instanceof RightBrace;

            boolean isEmpty = true;
            while (!stack.empty() && !(stack.peek() instanceof LeftBrace)) {
                result.add(stack.pop());
                isEmpty = false;
            }
            if (stack.empty() || isEmpty) {
                throw new VisitorException("Incorrect expression. Reason: bad braces");
            }
            stack.pop();
        }
    }

    @Override
    public void visit(final Operation token) {
        while (!stack.empty() && stack.peek() instanceof Operation && ((Operation) stack.peek()).priority() <= token.priority()) {
            result.add(stack.pop());
        }
        stack.push(token);
    }

    public List<Token> getReversePolishNotation() {
        while (!stack.isEmpty()) {
            final Token token = stack.pop();
            if (!(token instanceof Operation)) {
                throw new VisitorException("Incorrect expression");
            }
            result.add(token);
        }
        return result;
    }
}
