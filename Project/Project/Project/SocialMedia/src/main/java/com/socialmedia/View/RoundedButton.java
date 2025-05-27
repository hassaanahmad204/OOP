package com.socialmedia.View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.Cursor;

public class RoundedButton extends Button {
    public RoundedButton(String text, int radius, int textSize) {
        super(text);
        setFont(Font.font("New Times Roman", FontWeight.BOLD, textSize));
        setStyle(
                "-fx-background-radius: " + radius + ";" +
                        "-fx-background-color: " + toCssColor(GUIConstants.blue) + ";" +
                        "-fx-border-radius: " + radius + ";" +
                        "-fx-border-color: " + toCssColor(GUIConstants.blue) + ";" +
                        "-fx-border-width: 3;" +
                        "-fx-text-fill: " + toCssColor(GUIConstants.white) + ";" +
                        "-fx-alignment: center;" +
                        "-fx-padding: 10;"
        );

        // Set text alignment and cursor
        setAlignment(javafx.geometry.Pos.CENTER);
        setCursor(Cursor.HAND);

        // Clip to rounded rectangle for hit detection
        Rectangle clip = new Rectangle();
        clip.setArcWidth(radius);
        clip.setArcHeight(radius);
        setClip(clip);
        // Bind clip size to label size
        clip.widthProperty().bind(widthProperty());
        clip.heightProperty().bind(heightProperty());
    }

    // Convert javafx.scene.paint.Color to CSS hex
    private String toCssColor(Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255));
    }
}