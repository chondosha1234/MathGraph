module com.chondosha.mathgraph {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.chondosha.mathgraph to javafx.fxml;
    exports com.chondosha.mathgraph;
}