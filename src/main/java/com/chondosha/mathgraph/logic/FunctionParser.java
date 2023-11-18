package com.chondosha.mathgraph.logic;

import java.util.regex.*;

public class FunctionParser {

    public static double parseFunction(String expression, double x) {

        String substitutedExpression = expression.replaceAll("x", String.valueOf(x));

        String[] tokens = tokenize(substitutedExpression);

        return evaluate(tokens);
    }

    private static String[] tokenize(String expression) {
        // split expression into tokens based on operators
        return expression.split("(?<=[-+*/^()])|(?=[-+*/^()])");
    }

    private static double evaluate(String[] tokens) {
        // start parsing process from first token
        return parseExpression(tokens, 0);
    }

    private static double parseExpression(String[] tokens, int index) {
        double leftValue = parseTerm(tokens, index++);

        while (index < tokens.length && (tokens[index].equals("+") || tokens[index].equals("-"))) {
            // get the current operator (plus or minus at this level)
            String operator = tokens[index++];
            // get the second value on other side of operator (may require multiple recursive calls)
            double rightValue = parseTerm(tokens, index++);

            if (operator.equals("+")) {
                leftValue += rightValue;
            } else {
                leftValue -= rightValue;
            }
        }
        return leftValue;
    }

    private static double parseTerm(String[] tokens, int index) {
        double leftValue = parseFactor(tokens, index++);

        while (index < tokens.length && (tokens[index].equals("*") || tokens[index].equals("/"))) {
            String operator = tokens[index++];
            double rightValue = parseFactor(tokens, index++);

            if (operator.equals("*")) {
                leftValue *= rightValue;
            } else {
                leftValue /= rightValue;  // todo: think about proper division
            }
        }
        return leftValue;
    }

    private static double parseFactor(String[] tokens, int index) {
        if (tokens[index].equals("(")) {
            index++;  // move past left parentheses

            // deal with whole expression inside parentheses
            double result = parseExpression(tokens, index);

            index++; // move past right parentheses

            return result;

        } else if (tokens[index].equals("^")) {
            index++;  // move past ^ sign
            double base = parseFactor(tokens, index);
            double exponent = parseFactor(tokens, index);
            return Math.pow(base, exponent);
        } else {
            // parse numbers or constants
            return Double.parseDouble(tokens[index]);
        }

    }

    /**
     * Counts the number of terms in the parentheses, recursively in the case that there are multiple
     * open brackets.  This will help jump to the correct index in parseTerm and parseExpression whenever
     * an inner expression is evaluated and returned to a higher level
     */
    public static int countTermsInParentheses(String[] tokens, int index) {
        while (index < tokens.length && !tokens[index].equals(")")) {
            if (tokens[index].equals("(")) {
                index++;
                index += countTermsInParentheses(tokens, index);
            } else {
                index++;
            }
        }
        return index;
    }
}
