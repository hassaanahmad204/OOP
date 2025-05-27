package com.socialmedia.View;

import com.socialmedia.Controller.ReadUser;
import com.socialmedia.Model.Database;
import com.socialmedia.Model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.Cursor;
import javafx.stage.Stage;

public class Login {
    public Login(Database database, Stage stage) {

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #F5F5F5;");
        root.setPadding(new Insets(115, 0, 182, 0));

        StyledLabel title = new StyledLabel("Login", 40, GUIConstants.blue, 1);
        root.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);

        GridPane center = new GridPane();
        center.setStyle("-fx-background-color: transparent;");
        center.setPadding(new Insets(34, 315, 17, 315));
        center.setVgap(10);
        center.setHgap(10);

        HintTextField email = new HintTextField("Email");
        center.add(email, 0, 0);

        HintTextField password = new HintTextField("Password");
        center.add(password, 0, 1);


        RoundedButton login = new RoundedButton("Login", 45, 20);
        login.setOnMouseClicked(e -> {
            if (email.isEmpty()) {
                new Alert("Email cannot be empty", stage);
                return;
            }
            if (password.isEmpty()) {
                new Alert("Password cannot be empty", stage);
                return;
            }
            ReadUser read = new ReadUser(email.getText(), password.getText(), database);
            if (read.loggedIn()) {
                User user = read.getUser();
                new Alert("Logged in Successfully", stage);
                new Home(user, database,stage);
            } else {
                new Alert("Incorrect email or password", stage);
            }
        });
        center.add(login, 0, 2);
        center.setAlignment(Pos.CENTER);
        root.setCenter(center);

        // Create Account link: StyledLabel, clickable
        StyledLabel createAcc = new StyledLabel("Don't have an account? Create new one", 20, GUIConstants.black, 1); // 1 = BOLD
        createAcc.setAlignment(Pos.CENTER);
        createAcc.setCursor(Cursor.HAND);
        createAcc.setOnMouseClicked(e -> {
            new Welcome(database, stage);
        });
        root.setBottom(createAcc);
        BorderPane.setAlignment(createAcc, Pos.CENTER);

        Scene scene = new Scene(root, 900, 625);
        stage.setScene(scene);
        stage.requestFocus();
    }
}