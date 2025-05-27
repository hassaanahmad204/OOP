package com.socialmedia.View;

import com.socialmedia.Controller.UpdateUser;
import com.socialmedia.Model.Database;
import com.socialmedia.Model.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.Cursor;
import javafx.stage.Stage;

public class Modify {
    public Modify(User user, Database database, Stage stage) {

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #F5F5F5;");
        root.setPadding(new Insets(72, 84, 149, 84));

        StyledLabel title = new StyledLabel("Modify your Account", 40, GUIConstants.blue, 1);
        root.setTop(title);

        GridPane center = new GridPane();
        center.setStyle("-fx-background-color: transparent;");
        center.setPadding(new Insets(50, 231, 17, 231));
        center.setVgap(10);
        center.setHgap(10);

        HintTextField firstName = new HintTextField("First Name");
        firstName.setText(user.getFirstName());
        firstName.setStyle(firstName.getStyle() + "-fx-text-fill: " + toCssColor(GUIConstants.black) + ";");
        center.add(firstName, 0, 0);

        HintTextField lastName = new HintTextField("Last Name");
        lastName.setText(user.getLastName());
        lastName.setStyle(lastName.getStyle() + "-fx-text-fill: " + toCssColor(GUIConstants.black) + ";");
        center.add(lastName, 0, 1);

        HintTextField email = new HintTextField("Email");
        email.setText(user.getEmail());
        email.setStyle(email.getStyle() + "-fx-text-fill: " + toCssColor(GUIConstants.black) + ";");
        center.add(email, 0, 2);

        RoundedButton submit = new RoundedButton("Submit", 45, 20);
        submit.setOnMouseClicked(e -> {
            if (firstName.isEmpty()) {
                new Alert("First Name cannot be empty", stage);
                return;
            }
            if (lastName.isEmpty()) {
                new Alert("Last Name cannot be empty", stage);
                return;
            }
            if (email.isEmpty()) {
                new Alert("Email cannot be empty", stage);
                return;
            }
            if(!email.getText().matches("^[A-Za-z0-9+_.-]+@gmail\\.com$")){
                new Alert("Please enter valid Email",stage);
                return;
            }
            User updatedUser = user;
            updatedUser.setFirstName(firstName.getText());
            updatedUser.setLastName(lastName.getText());
            updatedUser.setEmail(email.getText());
            UpdateUser update = new UpdateUser(user, database);
            if (!email.getText().equals(user.getEmail()) && update.isEmailUsed()) {
                new Alert("This email has been used before", stage);
                return;
            }
            if (update.update()) {
                new Home(updatedUser, database, stage);
                new Alert("Profile updated successfully", stage);
            } else {
                new Home(user, database, stage);
            }
        });
        center.add(submit, 0, 3);
        center.setAlignment(Pos.CENTER);
        root.setCenter(center);

        StyledLabel changePassword = new StyledLabel("Change Password", 20, GUIConstants.black, 1); // 1 = BOLD
        changePassword.setAlignment(Pos.CENTER);
        changePassword.setCursor(Cursor.HAND);
        changePassword.setOnMouseClicked(e -> {
            new ChangePassword(user, database, stage);
        });
        root.setBottom(changePassword);
        BorderPane.setAlignment(changePassword, Pos.CENTER);

        Scene scene = new Scene(root, 900, 625);
        stage.setScene(scene);
        stage.requestFocus();
    }

    // Convert javafx.scene.paint.Color to CSS hex
    private String toCssColor(javafx.scene.paint.Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255));
    }
}