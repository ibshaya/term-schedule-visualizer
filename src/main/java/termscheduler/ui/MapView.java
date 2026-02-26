package termscheduler.ui;

import termscheduler.domain.Building;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

/**
 *  Visualization Area
 * Displays the campus map and draws the route between visited buildings.
 */
public class MapView extends StackPane {

    private final Canvas canvas;
    private final ImageView imageView;

    public MapView() {
        // Load map from resources
        Image mapImage = new Image(getClass().getResource("/map.png").toExternalForm(), 600, 0, true, true);
        imageView = new ImageView(mapImage);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setFitWidth(600); // scale for UI layout

        // Transparent canvas for overlays
        canvas = new Canvas(600, mapImage.getHeight() * (600 / mapImage.getWidth()));
        setAlignment(Pos.CENTER);
        getChildren().addAll(imageView, canvas);
    }

    /** Draws the route connecting buildings in order. */
    public void drawRoute(List<Building> routeBuildings) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (routeBuildings == null || routeBuildings.size() < 1)
            return;

        // Draw connecting lines
        gc.setStroke(Color.RED);
        gc.setLineWidth(3);
        for (int i = 0; i < routeBuildings.size() - 1; i++) {
            Building a = routeBuildings.get(i);
            Building b = routeBuildings.get(i + 1);
            gc.strokeLine(a.getX(), a.getY(), b.getX(), b.getY());
        }

        // Draw points with numbers
        gc.setFont(Font.font("Arial", 16));
        int index = 1;
        for (Building b : routeBuildings) {
            double x = b.getX();
            double y = b.getY();

            // Circle
            gc.setFill(Color.DEEPSKYBLUE);
            gc.fillOval(x - 10, y - 10, 20, 20);
            gc.setStroke(Color.BLACK);
            gc.strokeOval(x - 10, y - 10, 20, 20);

            // Number centered
            gc.setFill(Color.WHITE);
            gc.fillText(String.valueOf(index++), x - 4, y + 5);
        }
    }

    /** Clears route. */
    public void clear() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }
}
