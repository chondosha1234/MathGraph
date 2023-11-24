package com.chondosha.mathgraph.gui;

import javafx.geometry.Point3D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

public class GraphPanel2D {

    public static void render2DGraph(Canvas canvas, List<Point3D> points) {

        GraphicsContext gc = canvas.getGraphicsContext2D();

        // clear canvas
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // set up coordinate system
        double xAxisStart = 0;
        double xAxisEnd = canvas.getWidth();
        double yAxisStart = 0;
        double yAxisEnd = canvas.getHeight();

        // draw x axis
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeLine(xAxisStart, yAxisEnd/2, xAxisEnd, yAxisEnd/2);  // line across middle halfway of height

        // draw y axis
        gc.strokeLine(xAxisEnd/2, yAxisStart, xAxisEnd/2, yAxisEnd);

        gc.setStroke(Color.RED);
        gc.setLineWidth(2);

        for (Point3D point : points) {
            double x = point.getX();
            double y = point.getY();

            double screenX = mapXCoordinate(x, xAxisStart, xAxisEnd);
            double screenY = mapYCoordinate(y, yAxisStart, yAxisEnd);

            gc.strokeRect(screenX, screenY, 1, 1);  // draw small dot
        }
    }

    private static double mapXCoordinate(double x, double xAxisStart, double xAxisEnd) {
        return 0;
    }

    private static double mapYCoordinate(double y, double yAxisStart, double yAxisEnd) {
        return 0;
    }
}
