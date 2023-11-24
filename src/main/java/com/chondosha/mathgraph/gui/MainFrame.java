package com.chondosha.mathgraph.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFrame extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.chondosha.mathgraph.HelloApplication.class.getResource("hello-view.fxml"));

        // create main pane
        BorderPane mainPane = new BorderPane();

        // create top menu bar
        MenuBar menuBar = new MenuBar();
        Menu graphMenu = new Menu("Graph");
        Menu functionMenu = new Menu("Function");
        menuBar.getMenus().addAll(graphMenu, functionMenu);
        mainPane.setTop(menuBar);

        // create graph panel
        Button graphButton = new Button("Graph Panel Button");
        VBox graphPanel = new VBox();
        graphPanel.getChildren().add(graphButton);
        graphPanel.setPadding(new Insets(10));
        mainPane.setCenter(graphPanel);

        // create function input panel
        TextField functionTextField = new TextField();
        Button toggle2DButton = new Button("2D");
        Button toggle3DButton = new Button("3D");
        HBox functionInputPanel = new HBox();

        functionInputPanel.getChildren().addAll(functionTextField, toggle2DButton, toggle3DButton);
        functionInputPanel.setSpacing(10);
        functionInputPanel.setPadding(new Insets(10));
        mainPane.setBottom(functionInputPanel);

        Scene scene = new Scene(mainPane, 800, 800);
        stage.setTitle("Graphing");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
