module lab5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens lab5 to javafx.fxml;
    exports lab5;
    exports lab5.api;
    opens lab5.api to javafx.fxml;
    exports lab5.graphs;
    opens lab5.graphs to javafx.fxml;
}