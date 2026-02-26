package termscheduler.ui;

import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class ResultsPane extends VBox {

    private final TextArea resultsArea;

    public ResultsPane() {
        resultsArea = new TextArea();
        resultsArea.setEditable(false);
        resultsArea.setWrapText(true);
        resultsArea.setPrefHeight(500);
        resultsArea.setStyle("-fx-font-family: Consolas; -fx-font-size: 13px;");
        getChildren().add(resultsArea);
    }

    public void showText(String text) {
        resultsArea.setText(text);
    }

    public void showError(String msg) {
        resultsArea.setText(msg);
    }
}
