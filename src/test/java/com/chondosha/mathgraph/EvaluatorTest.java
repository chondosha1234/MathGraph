package com.chondosha.mathgraph;

import javafx.geometry.Point3D;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.chondosha.mathgraph.logic.Evaluator.evaluateFunction2D;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvaluatorTest {

    @Test
    void evaluate2DTest() {
        String expression = "x";
        double startX = -5.0;
        double endX = 5.0;
        double step = 1.0;

        List<Point3D> expectedList = Arrays.asList(
                new Point3D(-5.0, -5.0, 0),
                new Point3D(-4.0, -4.0, 0),
                new Point3D(-3.0, -3.0, 0),
                new Point3D(-2.0, -2.0, 0),
                new Point3D(-1.0, -1.0, 0),
                new Point3D(0.0, 0.0, 0),
                new Point3D(1.0, 1.0, 0),
                new Point3D(2.0, 2.0, 0),
                new Point3D(3.0, 3.0, 0),
                new Point3D(4.0, 4.0, 0),
                new Point3D(5.0, 5.0, 0)
        );

        List<Point3D> actualList = evaluateFunction2D(expression, startX, endX, step);

        for (int i = 0 ; i < expectedList.size(); i++) {
            Point3D actual = actualList.get(i);
            Point3D expected = expectedList.get(i);

            assertEquals(actual.getX(), expected.getX());
            assertEquals(actual.getY(), expected.getY());
            assertEquals(actual.getZ(), expected.getZ());
        }
    }

}
