package termscheduler.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import java.time.DayOfWeek;
import java.util.function.Consumer;

public class DaySelectorPane extends HBox {

    private final ToggleGroup toggleGroup = new ToggleGroup();

    public DaySelectorPane(Consumer<DayOfWeek> onDaySelected) {
        String[] dayLabels = {"U", "M", "T", "W", "R"};
        DayOfWeek[] dayEnums = {
                DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY
        };

        for (int i = 0; i < dayLabels.length; i++) {
            ToggleButton btn = new ToggleButton(dayLabels[i]);
            btn.setToggleGroup(toggleGroup);
            btn.setUserData(dayEnums[i]);
            btn.setPrefWidth(50);
            btn.setStyle("-fx-background-color: lightgray; -fx-font-size: 14px; -fx-font-weight: bold;");
            getChildren().add(btn);
        }

        setAlignment(Pos.CENTER);
        setPadding(new Insets(10));
        setSpacing(10);

        // highlight green when selected
        toggleGroup.selectedToggleProperty().addListener((obs, old, newToggle) -> {
            getChildren().forEach(node -> ((ToggleButton) node)
                    .setStyle("-fx-background-color: lightgray; -fx-font-size: 14px; -fx-font-weight: bold;"));
            if (newToggle != null) {
                ToggleButton selectedBtn = (ToggleButton) newToggle;
                selectedBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
                onDaySelected.accept((DayOfWeek) selectedBtn.getUserData());
            }
        });
    }
}
