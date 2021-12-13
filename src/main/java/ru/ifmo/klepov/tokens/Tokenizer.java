package ru.ifmo.klepov.tokens;

public class Tokenizer {
    final String expression;
    int currentIndex = 0;

    public Tokenizer(final String expression) {
        this.expression = expression;
    }

    private void skipSpaces() {
        while (currentIndex < expression.length() && Character.isWhitespace(expression.charAt(currentIndex))) {
            currentIndex++;
        }
    }

    public boolean hasToken() {
        skipSpaces();
        return currentIndex < expression.length();
    }

    public Token nextToken() {
        if (!hasToken()) {
            throw new TokenException("No tokens");
        }
        char currentChar = expression.charAt(currentIndex);
        if (Character.isDigit(currentChar)) {
            return new NumberToken(readNumber());
        } else {
            currentIndex++;
            return switch (currentChar) {
                case '(' -> new LeftBrace();
                case ')' -> new RightBrace();
                case '+' -> new Plus();
                case '-' -> new Minus();
                case '*' -> new Mul();
                case '/' -> new Div();
                default -> throw new TokenException("Incorrect symbol");
            };
        }
    }

    private long readNumber() {
        StringBuilder number = new StringBuilder();
        while (currentIndex < expression.length() && Character.isDigit(expression.charAt(currentIndex))) {
            number.append(expression.charAt(currentIndex++));
        }
        return Long.parseLong(number.toString());
    }
}
