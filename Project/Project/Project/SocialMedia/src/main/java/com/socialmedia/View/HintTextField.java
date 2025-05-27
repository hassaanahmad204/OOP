package com.socialmedia.View;

import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;

public class HintTextField extends TextField {
    private String hint;

    public HintTextField(String hint) {
        super(hint);
        this.hint = hint;

        setFont(Font.font("New Times Roman", FontWeight.BOLD, 20));

        setStyle(
                "-fx-background-radius: 45;" +
                        "-fx-background-color: white;" +
                        "-fx-border-radius: 45;" +
                        "-fx-border-color: white;" +
                        "-fx-border-width: 1;" +
                        "-fx-padding: 10 20;" +
                        "-fx-text-fill: " + toCssColor(GUIConstants.hintTextField) + ";"
        );

        Rectangle clip = new Rectangle();
        clip.setArcWidth(45);
        clip.setArcHeight(45);
        setClip(clip);
        clip.widthProperty().bind(widthProperty());
        clip.heightProperty().bind(heightProperty());

        focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                if (getText().equals(hint)) {
                    setText("");
                    setStyle(getBaseStyle() + "-fx-text-fill: " + toCssColor(GUIConstants.black) + ";");
                }
            } else {
                if (getText().isEmpty()) {
                    setText(hint);
                    setStyle(getBaseStyle() + "-fx-text-fill: " + toCssColor(GUIConstants.hintTextField) + ";");
                }
            }
        });
    }

    public boolean isEmpty() {
        return getText().isEmpty() || getText().equals(hint);
    }

    // Helper to get base CSS style without text-fill
    private String getBaseStyle() {
        return "-fx-background-radius: 45;" +
                "-fx-background-color: white;" +
                "-fx-border-radius: 45;" +
                "-fx-border-color: white;" +
                "-fx-border-width: 1;" +
                "-fx-padding: 10 20;";
    }

    private String toCssColor(Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255));
    }
}