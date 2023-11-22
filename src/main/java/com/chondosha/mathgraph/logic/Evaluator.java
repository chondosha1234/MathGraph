package com.chondosha.mathgraph.logic;

import javafx.geometry.Point3D;

import java.util.ArrayList;
import java.util.List;

import static com.chondosha.mathgraph.logic.FunctionParser.parseFunction;

public class Evaluator {

    /**
     *
     * @param expression
     * @param startX
     * @param endX
     * @param step
     * @return List<Point3D>
     *     Function that calls parseFunction on a string for each value of x in the range being viewed
     */
    public static List<Point3D> evaluateFunction2D(String expression, double startX, double endX, double step) {

        List<Point3D> points = new ArrayList<>();

        for (double x = startX; x <= endX; x += step) {
            double y = parseFunction(expression, x);
            points.add(new Point3D(x, y, 0));
        }
        return points;
    }

    /**
     *
     * @param expression
     * @param startX
     * @param endX
     * @param startY
     * @param endY
     * @param step
     * @return List<Point3D>
     *     Function to call parseFunction for each value of x and y in the range
     */
    public static List<Point3D> evaluateFunction3D(String expression, double startX, double endX, double startY, double endY, double step) {
        List<Point3D> points = new ArrayList<>();

        for (double x = startX; x <= endX; x += step) {
            for (double y = startY; y <= endY; y += step) {
                double z = parseFunction(expression, x, y);
                points.add(new Point3D(x, y, z));
            }
        }

        return points;
    }
}
