package com.chondosha.mathgraph.logic;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class FunctionParser {

    public static double parseFunction(String expression, double x) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("Javascript");

        try {
            // replace the character x with the double value given to function
            String substitutedExpression = expression.replaceAll("x", Double.toString(x));

            // use script engine to evaluate expression
            Object result = engine.eval(substitutedExpression);

            // turn into double and return
            return Double.parseDouble(result.toString());

        } catch (ScriptException e) {

            e.printStackTrace();
            // return NaN for invalid expression
            return Double.NaN;
        }
    }
}
