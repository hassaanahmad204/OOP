package com.socialmedia.View;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppWindow {
    private Stage stage;

    public AppWindow() {
        stage = new Stage();
        Pane root = new Pane();
        Scene scene = new Scene(root, 900, 625);

        // Set the background color of the root pane using JavaFX Background
        root.setBackground(new Background(new BackgroundFill(GUIConstants.background, null, null)));

        stage.setTitle("LinkZ");
        Image icon = new Image("logo2.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.DECORATED);

        stage.setOnCloseRequest(event -> Platform.exit());
    }

    public Stage getStage() {
        return stage;
    }
}