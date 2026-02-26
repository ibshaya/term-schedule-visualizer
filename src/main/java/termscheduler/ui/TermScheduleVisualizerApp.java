package termscheduler.ui;

import termscheduler.domain.*;
import termscheduler.excel.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.DayOfWeek;
import java.util.List;

public class TermScheduleVisualizerApp extends Application {

    private CourseSectionCollection collection;
    private final CampusMap campusMap = new CampusMap();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Term Schedule Visualizer");

        //Load Excel data
        ExcelScheduleReader reader = new ExcelScheduleReader();
        collection = reader.read("src/main/resources/schedule.xlsx");

        //Create UI components
        CrnInputPane crnInputPane = new CrnInputPane();  // (A) CRN input
        MapView mapView = new MapView();                 // (B) Visualization area
        ResultsPane resultsPane = new ResultsPane();     // (D) Results area

        //Day Selector
        Label resultsLabel = new Label("Results");
        resultsLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        DaySelectorPane daySelector = new DaySelectorPane(selectedDay ->
                updateResults(selectedDay, crnInputPane.getEnteredCrns(), resultsPane, mapView)
        );

        //results + buttons
        VBox rightPanel = new VBox(10, resultsLabel, daySelector, resultsPane);
        rightPanel.setAlignment(Pos.TOP_CENTER);
        rightPanel.setPadding(new Insets(10));
        rightPanel.setPrefWidth(360);
        rightPanel.setStyle("""
            -fx-background-color: #f7f7f7;
            -fx-border-color: #ccc;
            -fx-border-radius: 8;
            -fx-background-radius: 8;
        """);

        //Map container
        StackPane mapContainer = new StackPane(mapView);
        mapContainer.setAlignment(Pos.CENTER);
        mapContainer.setStyle("""
            -fx-border-color: #ccc;
            -fx-border-radius: 8;
            -fx-background-color: white;
        """);
        mapContainer.setPrefWidth(700);
        HBox.setHgrow(mapContainer, Priority.ALWAYS);

        // map + results side by side
        HBox contentBox = new HBox(15, mapContainer, rightPanel);
        contentBox.setAlignment(Pos.CENTER);
        contentBox.setPadding(new Insets(10));
        contentBox.setFillHeight(true);

        //Root layout
        VBox root = new VBox(15, crnInputPane, contentBox);
        root.setPadding(new Insets(10));
        VBox.setVgrow(contentBox, Priority.ALWAYS);

        Scene scene = new Scene(root, 1150, 750);

        stage.initStyle(StageStyle.DECORATED);




        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMinWidth(950);
        stage.setMinHeight(600);
        stage.setMaximized(false);


        stage.show();
    }

    /**
     * Handles filtering and visualization updates when a day is selected.
     */
    private void updateResults(DayOfWeek selectedDay, List<String> crns,
                               ResultsPane resultsPane, MapView mapView) {
        if (collection == null) {
            resultsPane.showError("No schedule loaded.");
            mapView.clear();
            return;
        }

        if (crns.isEmpty()) {
            resultsPane.showError("Please enter at least one CRN.");
            mapView.clear();
            return;
        }

        List<CourseSection> filtered =
                ScheduleFilter.filterByDayAndCRNs(collection, crns, selectedDay);

        if (filtered.isEmpty()) {
            resultsPane.showText("No sections found for " + selectedDay + ".");
            mapView.clear();
            return;
        }

        double totalDistance = RouteCalculator.calculateTotalDistance(filtered, campusMap);
        long distinctBuildings = filtered.stream()
                .map(CourseSection::getBuilding)
                .distinct()
                .count();

        StringBuilder sb = new StringBuilder();
        sb.append("Selected Day: ").append(selectedDay).append("\n");
        sb.append("Number of Courses = ").append(filtered.size()).append("\n\n");

        int idx = 1;
        for (CourseSection s : filtered) {
            sb.append(idx++).append("- ")
                    .append(s.getDept()).append(" ")
                    .append(s.getCode()).append(": ")
                    .append(s.getTitle()).append("\n");
        }

        sb.append("\nNumber of Different Buildings = ").append(distinctBuildings).append("\n");
        sb.append(String.format("Distance Traveled = %.1f m", totalDistance));

        resultsPane.showText(sb.toString());
        mapView.drawRoute(RouteCalculator.getRoutePath(filtered, campusMap));
    }

    public static void main(String[] args) {
        launch();
    }
}
