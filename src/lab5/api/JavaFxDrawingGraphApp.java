package lab5.api;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
public class JavaFxDrawingGraphApp extends Application {
    private static Canvas canvas = null;

    public static void init(Canvas canvas) {
        JavaFxDrawingGraphApp.canvas = canvas;
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
