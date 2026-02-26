package termscheduler.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MapCoordinatePicker extends Application {

    private static final String MAP_PATH = "file:src/main/resources/img.png";

    @Override
    public void start(Stage primaryStage) {
        Image map = new Image(MAP_PATH);
        Canvas canvas = new Canvas(map.getWidth(), map.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.drawImage(map, 0, 0);

        // draw a small dot when clicked and print coordinates
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            double x = e.getX();
            double y = e.getY();

            // draw a red dot where clicked
            gc.setFill(Color.RED);
            gc.fillOval(x - 3, y - 3, 6, 6);

            // print coordinates in console
            System.out.printf("Building at (x=%.0f, y=%.0f)%n", x, y);
        });

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Campus Map Coordinate Picker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
