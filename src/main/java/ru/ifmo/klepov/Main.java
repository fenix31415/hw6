package ru.ifmo.klepov;

import ru.ifmo.klepov.tokens.Token;
import ru.ifmo.klepov.tokens.Tokenizer;
import ru.ifmo.klepov.visitors.CalcVisitor;
import ru.ifmo.klepov.visitors.ParserVisitor;
import ru.ifmo.klepov.visitors.PrintVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            final ParserVisitor parserVisitor = new ParserVisitor();
            final PrintVisitor printVisitor = new PrintVisitor();
            final CalcVisitor calcVisitor = new CalcVisitor();

            final List<Token> tokens = new ArrayList<>();
            final Tokenizer tokenizer = new Tokenizer((new Scanner(System.in)).nextLine());
            
            while (tokenizer.hasToken()) {
                tokens.add(tokenizer.nextToken());
            }
            for (final Token token : tokens) {
                token.accept(parserVisitor);
            }

            final List<Token> rpn = parserVisitor.getReversePolishNotation();
            for (final Token token : rpn) {
                token.accept(printVisitor);
            }
            System.out.println();

            for (final Token token : rpn) {
                token.accept(calcVisitor);
            }
            System.out.println("Calculated value: " + calcVisitor.calculate());
        } catch (final RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
