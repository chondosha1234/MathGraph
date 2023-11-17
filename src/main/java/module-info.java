module com.chondosha.mathgraph {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.scripting;
    requires org.junit.jupiter.api;


    opens com.chondosha.mathgraph to javafx.fxml;
    exports com.chondosha.mathgraph;
}