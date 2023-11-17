package com.chondosha.mathgraph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.chondosha.mathgraph.logic.FunctionParser.parseFunction;

public class FunctionParserTest {

    @Test
    void parseFunctionTest() {
        String expression = "x + 2";
        double x = 1.0;
        double functionValue = parseFunction(expression, x);
        assertEquals(functionValue, 3.0);
    }
}
