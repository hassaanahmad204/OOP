package com.socialmedia.Main;

import com.socialmedia.Model.Database;
import com.socialmedia.View.AppWindow;
import com.socialmedia.View.Welcome;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        AppWindow appWindow = new AppWindow();
        Stage stage = appWindow.getStage();
        Database database = new Database();
        new Welcome(database, stage);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}