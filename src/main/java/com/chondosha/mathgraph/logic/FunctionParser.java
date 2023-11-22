package com.chondosha.mathgraph.logic;

import java.util.ArrayList;
import java.util.regex.*;

public class FunctionParser {

    public static double parseFunction(String expression, double x) {

        String substitutedExpression = expression.replaceAll("x", String.valueOf(x));

        String[] tokens = tokenize(substitutedExpression);

        return evaluate(tokens);
    }

    private static String[] tokenize(String expression) {
        // split expression into tokens based on operators
        String[] tokens = expression.split("(?<=[-+*/^()])|(?=[-+*/^()])");
        tokens = cleanArray(tokens);
        return tokens;
    }

    /**
     * Method to go through array of tokens and remove empty space strings that may be in it
     * Some users may type like this 3+(2*x)  and others like this 3 + ( 2 * x )  the second will create " " tokens
     */
    private static String[] cleanArray(String[] tokens) {

        ArrayList<String> cleanedList = new ArrayList<>();
        for (String token : tokens) {
            if (!token.equals(" ")) {
                cleanedList.add(token);
            }
        }
        return cleanedList.toArray(new String[cleanedList.size()]);
    }

    private static double evaluate(String[] tokens) {
        // start parsing process from first token
        return parseExpression(tokens, 0);
    }

    private static double parseExpression(String[] tokens, int index) {
        double leftValue = parseTerm(tokens, index);

        if (tokens[index].equals("(")) {
            index += countTermsInParentheses(tokens, index) + 1;
        } else {
            index++;
        }

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
        double leftValue = parseFactor(tokens, index);

        if (tokens[index].equals("(")) {
            index += countTermsInParentheses(tokens, index) + 1;
        } else {
            index++;
        }

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

            //index++; // move past right parentheses

            return result;

        } else if (index+2 < tokens.length && tokens[index+1].equals("^")) {
            // if the next symbol is exponent, it should immediately evaluate the term after carrot as the power and return evaluated term
            double base = Double.parseDouble(tokens[index]);
            double exponent = parseExpression(tokens, index+2);
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
        int startIndex = index;
        index++;
        while (index < tokens.length && !tokens[index].equals(")")) {
            if (tokens[index].equals("(")) {
                index++;
                index += countTermsInParentheses(tokens, index);
            } else {
                index++;
            }
        }
        return index - startIndex;
    }
}
