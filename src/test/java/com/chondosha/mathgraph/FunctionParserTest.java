package com.chondosha.mathgraph;

import org.junit.jupiter.api.Test;

import static com.chondosha.mathgraph.logic.FunctionParser.countTermsInParentheses;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.chondosha.mathgraph.logic.FunctionParser.parseFunction;

public class FunctionParserTest {

    @Test
    void parseFunctionTest() {

    }

    @Test
    void parseFunctionAddTest() {
        String expression = "x + 2";
        double x = 5.0;
        double functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 7.0);

        expression = "2 + x";
        x = 1.0;
        functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 3.0);

        // add negatives
    }

    @Test
    void parseFunctionSubtractTest() {
        String expression = "x - 3.5";
        double x = 4.0;
        double functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 0.5);

        expression = "2 - x";
        functionValue = parseFunction(expression, x);
        assertEquals(functionValue, -2.0);
    }

    @Test
    void parseFunctionMultiplyTest() {
        String expression = "x * 3";
        double x = 2.5;
        double functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 7.5);

        x = 2.0;
        expression = "4 * 3 * x";
        functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 24.0);
    }

    @Test
    void parseFunctionDivideTest() {
        String expression = "10 / x";
        double x = 2.0;
        double functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 5.0);

        expression = "x / 5";
        x = 15.0;
        functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 3.0);

        // add fraction test / divide by zero
    }

    @Test
    void parseFunctionPowerTest() {
        String expression = "2^x";
        double x = 4.0;
        double functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 16.0);

        expression = "3 + 2^(x + 2)";
        x = 2.0;
        functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 19.0);

        // add test of roots  1/2 powers etc.
        expression = "4^(x)";
        x = 0.5;  // sqrt
        functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 2.0);
    }

    @Test
    void parseFunctionParenthesesTest() {
        String expression = "(3 + x) * 2";
        double x = 4.0;
        double functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 14.0);

        expression = "2 + (4 - 2) * x";
        functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 10.0);
    }

    @Test
    void countTermsInParenthesesTest() {

        // basic counting the tokens in parentheses
        String[] tokens = new String[] {"(", "2", "+", "2", ")"};
        int index = 0;
        index = countTermsInParentheses(tokens, index);
        assertEquals(4, index);

        // tests to make sure it doesn't count the terms outside of parentheses
        tokens = new String[] {"(", "2", "+", "2", ")", "+", "5"};
        index = 0;
        index = countTermsInParentheses(tokens, index);
        assertEquals(4, index);

        // test nested parentheses
        tokens = new String[] {"(", "(", "2", "+", "2", ")", "+", "2", ")"};
        index = 0;
        index = countTermsInParentheses(tokens, index);
        assertEquals(8, index);
    }

    @Test
    void cleanArrayTest() {

    }
}
