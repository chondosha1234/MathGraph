package com.chondosha.mathgraph.gui;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainFrameController {

    @FXML
    private Canvas graphCanvas;

    public void initialize() {
        drawCoordinatePlane();
    }

    protected void drawCoordinatePlane() {
        GraphicsContext gc = graphCanvas.getGraphicsContext2D();
        double width = graphCanvas.getWidth();
        double height = graphCanvas.getHeight();
        double centerX = width / 2;
        double centerY = height / 2;

        // Clear canvas
        gc.clearRect(0, 0, width, height);

        // Draw grid
        double gridSize = 20;
        gc.setStroke(Color.LIGHTGRAY);
        gc.setLineWidth(0.5);

        // Draw vertical grid lines
        for (double x = centerX % gridSize; x < width; x += gridSize) {
            gc.strokeLine(x, 0, x, height);
        }

        // Draw horizontal grid lines
        for (double y = centerY % gridSize; y < height; y += gridSize) {
            gc.strokeLine(0, y, width, y);
        }

        // Draw X-axis
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1.0);
        gc.strokeLine(0, centerY, width, centerY);

        // Draw Y-axis
        gc.strokeLine(centerX, 0, centerX, height);

        gc.setFont(new Font(8));

        // Draw tick marks and labels on X-axis
        for (double x = gridSize; x < width; x += gridSize) {
            gc.strokeLine(x, centerY - 5, x, centerY + 5);
            gc.fillText(String.valueOf((x - centerX) / gridSize), x - 10, centerY + 20);
        }

        // Draw tick marks and labels on Y-axis
        for (double y = gridSize; y < height; y += gridSize) {
            gc.strokeLine(centerX - 5, y, centerX + 5, y);
            gc.fillText(String.valueOf((centerY - y) / gridSize), centerX + 10, y + 5);
        }
    }

    @FXML
    private Button graphButton;

    @FXML
    private Button toggle2DButton;

    @FXML
    private Button toggle3DButton;
}
