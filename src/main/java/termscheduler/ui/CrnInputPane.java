package termscheduler.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CrnInputPane extends HBox {

    private final TextField crnField;

    public CrnInputPane() {
        Label label = new Label("Enter Student CRN Numbers:");
        crnField = new TextField();
        crnField.setPromptText("e.g. 11695 14313 10744 15375");
        crnField.setPrefWidth(400);

        setSpacing(10);
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(10));
        getChildren().addAll(label, crnField);
    }

    /** Returns CRNs entered as a list of strings. */
    public List<String> getEnteredCrns() {
        return Arrays.stream(crnField.getText().trim().split("\\s+"))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
    }
}
