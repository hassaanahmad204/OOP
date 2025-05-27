package com.socialmedia.View;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class StyledLabel extends Label {
    public StyledLabel(String text, int textSize, Color color, int style) {
        super(text);

        FontWeight weight = (style & 1) == 1 ? FontWeight.BOLD : FontWeight.NORMAL;
        FontPosture posture = (style & 2) == 2 ? FontPosture.ITALIC : FontPosture.REGULAR;

        setFont(Font.font("New Times Roman", weight, posture, textSize));
        setTextFill(color);
    }
}