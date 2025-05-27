package com.socialmedia.View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Alert {
    public Alert(String content, Stage parent) {
        Stage stage = new Stage();
        stage.setWidth(430);
        stage.setHeight(170);
        stage.setResizable(false);

        // Main panel: BorderPane
        BorderPane panel = new BorderPane();
        panel.setPadding(new Insets(15));
        panel.setStyle("-fx-background-color: " + toCssColor(GUIConstants.white) + ";");

        StyledLabel title = new StyledLabel("Alert", 24, GUIConstants.blue, 1);
        panel.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);
        BorderPane.setMargin(title, new Insets(0, 0, 5, 0));

        StyledLabel msg = new StyledLabel(content, 18, GUIConstants.black, 1);
        panel.setCenter(msg);
        BorderPane.setAlignment(msg, Pos.CENTER);
        BorderPane.setMargin(msg, new Insets(5, 0, 0, 0));

        Scene scene = new Scene(panel);
        stage.setScene(scene);

        if (parent != null) {
            stage.centerOnScreen();
            stage.setX(parent.getX() + (parent.getWidth() - stage.getWidth()) / 2);
            stage.setY(parent.getY() + (parent.getHeight() - stage.getHeight()) / 2);
        } else {
            stage.centerOnScreen();
        }

        stage.show();

        stage.setOnCloseRequest(e -> stage.close());
    }

    private String toCssColor(javafx.scene.paint.Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255));
    }
}